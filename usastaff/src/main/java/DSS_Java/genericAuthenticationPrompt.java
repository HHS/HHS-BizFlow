package DSS_Java;

/**
Licensed Materials - Property of IBM

IBM Cognos Products: DOCS

(C) Copyright IBM Corp. 2008, 2009

US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
Schedule Contract with IBM Corp.
*/
/**
 * genericAuthenticationPrompt.java
 *
 * Copyright (C) 2009 IBM. All rights reserved.
 * Cognos (R) is a trademark of Cognos ULC, (formerly Cognos Incorporated).
 *
 * Description: This sample application uses Cognos Mashup Service (CMS) to
 * 				retrieve the LayoutDataXML output of a given report and save it to a
 * 				file called "reportOutput.xml". The user will be prompted to authenticate
 * 				if required. The program will logoff when the report has completed.
 */

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.rmi.RemoteException;
import org.apache.axis.client.Stub;
import org.apache.axis.message.SOAPHeaderElement;

import com.cognos.developer.schemas.ccs.auth.types._1.*;
import com.cognos.developer.schemas.rds.types._2.*;
import com.cognos.developer.schemas.bibus._3.*;

public class genericAuthenticationPrompt
{
	private static String url = "http://localhost/ibmcognos/cgi-bin/cognos.cgi";
	private static String searchPath;
	private static boolean logonFirst = false;

	/**
	 * Main entry point
	 *
	 * @param args
	 * Command line parameters. The options include -u: Specify the
	 * IBM Cognos server gateway, default is
	 * "http://localhost/ibmcognos/cgi-bin/cognos.cgi" -l: Force logon,
	 * Prompt user to logon before running report -?: Prints a help
	 * message about the various options 'searchPath':The search path
	 * the the report. Required.
	 */
	public static void main(String[] args)
	{
		try
		{
			parseCommandLineOptions(args);
			System.out.print("Using server: ");
			System.out.println(url);
			System.out.print("Running report: ");
			System.out.println(searchPath);

			ReportDataServiceLocator cmsLocator = new ReportDataServiceLocator();
			ReportDataServicePort cmsService = cmsLocator.getReportDataServiceBinding(new URL(url));

			if (logonFirst)
			{
				logon(cmsService);
			}
			else
			{
				System.out.println("Logging on as anonymous");
			}

			runReport(cmsService);
			logoff(cmsService);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	/**
	 * Runs the report
	 *
	 * @param cmsService
	 *            Reference to the CMS service stub
	 * @throws RemoteException
	 *             An Axis Exception
	 * @throws CCSGeneralFault
	 *             Thrown if the report could not be run
	 * @throws CCSPromptFault
	 *             Thrown if the report requires prompts
	 * @throws FileNotFoundException
	 *             Thrown if the file could not be created
	 * @throws IOException
	 *             Thrown if an IO error occurs
	 */
	private static void runReport(ReportDataServicePort cmsService) throws RemoteException, CCSGeneralFault, CCSPromptFault, FileNotFoundException, IOException
	{
		try
		{
			System.out.println("Running report. Please wait...");
			GetReportDataRequest req = new GetReportDataRequest();
			req.setSourceType(SourceTypeEnum.searchPath);
			req.setSourceID(searchPath);
			req.setFormat("layoutDataXML");
			GetOutputResponse response = cmsService.getReportData(req);
			while (response.getSession().getStatus() == SessionTypeStatus.working)
			{
				copySOAPHeaders((Stub) cmsService, (Stub) cmsService);
				GetOutputRequest pollingRequest = new GetOutputRequest(response.getSession(), null);
				response = cmsService.getOutput(pollingRequest);
			}

			FileOutputStream outStream = new FileOutputStream("reportOutput.xml");
			outStream.write((response.getOutput().getFormatOutput().getBytes()));
			outStream.close();

			System.out.println("Output written to reportOutput.xml");
		}
		catch (CCSAuthenticationFault e)
		{
			System.out.println("Logon required. Please enter your credentials");
			logon(cmsService);
			runReport(cmsService);
		}
	}

	/**
	 * Logs onto IBM Cognos Server Using the CMS Authentication Service, then copies the SOAP
	 * Header from the Auth Service to CMS. This request begins by passing an
	 * empty CredentialType object to the AuthService. If additional credentials
	 * are required, the Auth Service will return a CredentialType object
	 * containing a number of credential elements. The credential elements may
	 * contain "actual values", if the value of the element is known or "missing
	 * values" if the value needs to be provided by the user.
	 *
	 * @param cmsService
	 *            Reference to the CMS service stub.
	 */
	private static void logon(ReportDataServicePort cmsService)
	{
		try
		{
			System.setProperty("https.protocols", "TLSv1.1,TLSv1.2");
			AuthServiceLocator authLocator = new AuthServiceLocator();
			AuthServicePort authService = (AuthServicePort) authLocator.getAuthServicePort(new URL(url));
			doLogon(authService, new CredentialType());
			copySOAPHeaders((Stub) authService, (Stub) cmsService);
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Logs off from IBM Cognos server
	 */
	private static void logoff(ReportDataServicePort cmsService)
	{
		try
		{
			AuthServiceLocator authLocator = new AuthServiceLocator();
			AuthServicePort authService = (AuthServicePort) authLocator.getAuthServicePort(new URL(url));
			copySOAPHeaders((Stub) cmsService, (Stub) authService);
			authService.logoff(new LogoffRequestType());
		}
		catch (Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
	}

	/**
	 * Authenticates with the current credentials, and prompts the user to
	 * provide missing information. This process of authenticating and prompting
	 * repeats until a complete credential is built.
	 *
	 * The logon call will either return a CredentialType object, if additional
	 * credential elements are required, or an AccountInfo object if
	 * authentication is complete.
	 *
	 * If a CredentialType object is returned, we iterate through the credential
	 * elements and prompt the user. The prompting uses an ACredentialPrompt
	 * subclass to provide the right type of prompting depending on the
	 * information required.
	 *
	 * If the credential has an Actual Value, then a ValueCredential object is
	 * used to display the fixed value
	 *
	 * If the credential has a Missing Value with an enumeration of possible
	 * values, a ChoiceCredential object is used to prompt the user to select
	 * one of the allowed values
	 *
	 * If the credential has a Missing Value with no enumeration of allowed
	 * values, a TypeInCredential object is used to prompt the user to type in
	 * the value
	 *
	 * @param authService
	 *            Reference to the CMS Auth Service Stub
	 * @param credentials
	 *            The CredentialType object that contains the user's credentials
	 * @return The updated CredentialType object
	 * @throws RemoteException
	 *             Thrown if an Axis exception occurs
	 */
	private static CredentialType doLogon(AuthServicePort authService, CredentialType credentials) throws RemoteException
	{
		LogonResponseType response = authService.logon(new LogonRequestType(credentials, null));
		if (response.getResponseCode() == ResponseCode.ERROR)
		{
			System.out.println(response.getResponseMessage());
			System.exit(-1);
		}
		if (response.getResult().getCredentialPrompt() != null)
		{
			credentials = response.getResult().getCredentialPrompt();
			CredentialElementType[] elements = credentials.getCredentialElements();
			for (int i = 0; i < elements.length; i++)
			{
				ACredentialPrompt credential;
				if (elements[i].getValue().getActualValue() != null)
					credential = new ValueCredential(elements[i]);
				else
					credential = new TypeInCredential(elements[i]);
				credential.promptUser();
				elements[i] = credential.getCredential();
			}
			credentials = doLogon(authService, credentials);
		}
		else if (response.getResult().getAccountInfo() != null)
		{
			System.out.println("Logged in as: " + response.getResult().getAccountInfo().getDisplayName());
		}
		return credentials;
	}

	/**
	 * IBM Cognos server carries authentication and routing information in the SOAP
	 * Header. Axis does not automatically copy headers from a response envelope
	 * to the next request, so this utility function perfoms the copy from one
	 * stub to the other
	 *
	 * @param source
	 *            The source Stub (the response)
	 * @param cmsService
	 *            Reference to the CMS stub
	 */
	private static void copySOAPHeaders(Stub source, Stub target)
	{
		SOAPHeaderElement[] header = source.getResponseHeaders();
		for (int i = 0; i < header.length; i++)
		{
			target.setHeader(header[i]);
		}
	}

	/**
	 * Parses the command line options
	 *
	 * @param args
	 */
	private static void parseCommandLineOptions(String[] args)
	{
		if (args != null)
		{
			if (args.length < 1 || args.length > 4)
			{
				printUsage();
				System.exit(-1);
			}
			for (int i = 0; i < args.length; i++)
			{
				if (args[i].startsWith("-u"))
				{
					url = args[(i + 1)];
				}
				else if (args[i].equals("-?"))
				{
					printUsage();
					System.exit(0);
				}
				else if (args[i].equals("-l"))
				{
					logonFirst = true;
				}
				else
				{
					searchPath = args[i];
				}
			}
		}
		if (searchPath == null)
		{
			printUsage();
			System.exit(-1);
		}
	}

	/**
	 * Prints a help message indicating the command line arugments
	 */
	private static void printUsage()
	{
		System.out.println("Usage: java genericAuthenticationPrompt [options] <searchPath>");
		System.out.println("Options:");
		System.out.println("-u <url>: URL to the IBM Cognos gateway, i.e. http://localhost/ibmcognos/cgi-bin/cognos.cgi");
		System.out.println("-?: Prints this help message");
		System.out.println("-l: Logon before running the report");
	}

}
