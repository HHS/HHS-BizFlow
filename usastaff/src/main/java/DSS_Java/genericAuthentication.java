package DSS_Java;

/**
Licensed Materials - Property of IBM

IBM Cognos Products: DOCS

(C) Copyright IBM Corp. 2008, 2009

US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP
Schedule Contract with IBM Corp.
*/
/**
* genericAuthentication.java
*
* Copyright (C) 2008 Cognos ULC, an IBM Company. All rights reserved.
* Cognos (R) is a trademark of Cognos ULC, (formerly Cognos Incorporated).
*
* Description: This code sample demonstrates how to get report output
*	           using the IBM Cognos Mashup Service generic SOAP interface
*              This sample needs to provide login credentials
*
*/


import java.io.*;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.cognos.developer.schemas.bibus._3.*;
import com.cognos.developer.schemas.ccs.auth.types._1.*;
import com.cognos.developer.schemas.rds.types._2.*;

public class genericAuthentication {
	
	private String serverURL = null;
	private boolean prompted = false;
	private org.apache.axis.message.SOAPHeaderElement[] headers = null;
	ReportDataServicePort rdsservice = null;
    GetPromptAnswersResponse pa_response = new GetPromptAnswersResponse();
    
    public void setURL(String url)
	{
		serverURL = url;
	}

	public String getReportOutput (String strNameSpace, String strUserName, String strPassword, String strReportID, String strFMT) {

	 String result=null;

	 try
	 {
		//User credentials are passed to the IBM Cognos server.
		//Replace namespace, username, and password with the appropriate credentials
		String nameSpaceStr=strNameSpace;    //namespace
		String userNameStr=strUserName;      //username
		String userPasswordStr=strPassword;  //password
		String reportIDStr=strReportID;      //reportID
		String reportFMTStr = strFMT;        //reportFMT

		AuthServiceLocator authlocator = new AuthServiceLocator();
		//AuthServicePort authService = (AuthServicePort) authlocator.getAuthServicePort(new URL(serverURL));
		AuthServiceBindingStub authservice = (AuthServiceBindingStub) authlocator.getAuthServicePort(new URL(serverURL)) ;
		CredentialType credentialType = new CredentialType();

		CredentialElementType nameSpaceElement = new CredentialElementType();
		ValueElementType nameSpaceValue = new ValueElementType();
		nameSpaceValue.setActualValue(nameSpaceStr);
		nameSpaceElement.setName("CAMNamespace");
		nameSpaceElement.setValue(nameSpaceValue);

		CredentialElementType userNameElement = new CredentialElementType();
		ValueElementType userNameValue = new ValueElementType();
		userNameValue.setActualValue(userNameStr);
		userNameElement.setName("CAMUsername");
		userNameElement.setValue(userNameValue);

		CredentialElementType passWordElement = new CredentialElementType();
		ValueElementType passWordValue = new ValueElementType();
		passWordValue.setActualValue(userPasswordStr);
		passWordElement.setName("CAMPassword");
		passWordElement.setValue(passWordValue);

		//Login IBM Cognos server using the CMS Authentication Service
		System.setProperty("http.agent", "Mozilla/5.0 (compatible, MSIE 11, Windows NT 6.3; Trident/7.0;  rv:11.0)");
		System.setProperty("https.protocols", "TLSv1.1,TLSv1.2");
		credentialType.setCredentialElements(new CredentialElementType[]{nameSpaceElement,userNameElement,passWordElement});
		LogonRequestType logonRequest = new LogonRequestType(credentialType, null);
		@SuppressWarnings("unused")
		LogonResponseType logonResponse = authservice.logon(logonRequest);
		//Copy the SOAP header from the Authentication Service to CMS
		headers=((org.apache.axis.client.Stub) authservice).getResponseHeaders();

		//A report instance is created
		ReportDataServiceLocator rdslocator = new ReportDataServiceLocator();
		rdsservice = rdslocator.getReportDataServiceBinding(new URL(serverURL));
		//The Authentication credentials are passed to the report-specific service
		((org.apache.axis.client.Stub) rdsservice).setHeader(headers[0]);
		
		GetReportPromptsRequest pd_request = new GetReportPromptsRequest();
		pd_request.setSourceID(reportIDStr);
        pd_request.setSourceType(SourceTypeEnum.searchPath);
        GetOutputResponse pd_response = rdsservice.getReportPrompts(pd_request);
        pd_response = waitForOutput(pd_response);

        prompted = false;
        try
        {
        	LDXOutputType ldx = pd_response.getOutput().getLDXOutput();
        	if (ldx.getDocument().getPages() != null)
        	{
                prompted = true;
        	}
        }
        catch (NullPointerException npe) {prompted = false;};
        //Get prompt answers if necessary
        if (prompted)
        {
            prompted = true;
            GetPromptPageRequest p_request = new GetPromptPageRequest();
            p_request.setSourceID(reportIDStr);
            p_request.setSourceType(SourceTypeEnum.searchPath);
            GetPromptPageResponse p_response = rdsservice.getPromptPage(p_request);
            try
            {
            	String respString = p_response.getUrl().toString().substring(33, p_response.getUrl().toString().length());
            	//int exitVal = Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe " + p_response.getUrl().toString() + "&CAMNamespace=" + strNameSpace + "&CAMUsername=" + strUserName + "&CAMPassword=" + strPassword).waitFor();
            	int exitVal = Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe " + this.serverURL.substring(0, this.serverURL.indexOf("ibmcognos/bi/v1")) + respString + "&CAMNamespace=" + strNameSpace + "&CAMUsername=" + strUserName + "&CAMPassword=" + strPassword).waitFor();
               	System.out.println("ExitValue: " + exitVal); 
				GetPromptAnswersRequest pa_request = new GetPromptAnswersRequest();
                pa_request.setPromptID(p_response.getPromptID());
                pa_response = rdsservice.getPromptAnswers(pa_request);
            }
            catch (Exception e)
            {
            	System.console().writer().write(e.getMessage());
            }
        }

		//Retrieve the LDX output of a given report
		GetReportDataRequest reportFormatRequest = new GetReportDataRequest();
		reportFormatRequest.setFormat(reportFMTStr);
		//The sourceID for the report will vary by IBM Cognos deployment
		reportFormatRequest.setSourceID(reportIDStr);
		reportFormatRequest.setSourceType(SourceTypeEnum.searchPath);
		if (prompted) reportFormatRequest.setPromptValues(pa_response.getPromptValues());
		GetOutputResponse response = rdsservice.getReportData(reportFormatRequest);
		//An asynchronous request, the application loops until the report output is returned
		while (response.getSession().getStatus().getValue() == SessionTypeStatus._working)
		{
			GetOutputRequest oreq = new GetOutputRequest(response.getSession(), null);
			headers = ((org.apache.axis.client.Stub) rdsservice).getResponseHeaders();
			((org.apache.axis.client.Stub) rdsservice).setHeader(headers[0]);
			response = rdsservice.getOutput(oreq);
		}

		result=response.getOutput().getFormatOutput();

		try
		{
			//Save LDX output to a file called reportOutput.xml
			@SuppressWarnings("resource")
			FileOutputStream outputFile=new FileOutputStream("reportOutput.xml");
			outputFile.write(response.getOutput().getFormatOutput().getBytes());
			System.out.println("The report output is saved in reportOutput.xml file.");

		}
		catch(Exception e)
		{
			System.out.println("Error"+e.getMessage());
			return e.getMessage();
		}

		headers=((org.apache.axis.client.Stub) rdsservice).getResponseHeaders();
		((org.apache.axis.client.Stub) authservice).setHeader(headers[0]);

		//The user is logged off from IBM Cognos server
		LogoffRequestType LogoffRequest = new LogoffRequestType();
		@SuppressWarnings("unused")
		LogoffResponseType logoff = authservice.logoff(LogoffRequest);
	}
	catch (CCSGeneralFault e) {
		e.printStackTrace();
		return "Please make sure the report ID is correct ...";
	}
	catch (CCSPromptFault e) {
		e.printStackTrace();
		return "Please make sure the report ID is correct ...";
	}
	catch (CCSAuthenticationFault e) {
		e.printStackTrace();
		return "Login Failed. Please try again.";
	}
	catch (RemoteException e) {
		e.getMessage();
		return e.getMessage();
	}
	catch (ServiceException e) {
		e.printStackTrace();
		return e.getMessage();
	}
	catch (Exception e)
	{
		e.printStackTrace();
	}

	return result;
	}
	
	private GetOutputResponse waitForOutput(GetOutputResponse resp) throws RemoteException, CCSAuthenticationFault, CCSPromptFault, CCSGeneralFault
	{
		while (resp.getSession().getStatus() == SessionTypeStatus.working)
		{
			GetOutputRequest waitReq = new GetOutputRequest(resp.getSession(), null);
			headers = ((org.apache.axis.client.Stub) rdsservice).getResponseHeaders();
			((org.apache.axis.client.Stub) rdsservice).setHeader(headers[0]);
			resp = rdsservice.getOutput(waitReq);
		}
		headers = ((org.apache.axis.client.Stub) rdsservice).getResponseHeaders();
		((org.apache.axis.client.Stub) rdsservice).setHeader(headers[0]);
		return resp;
	}
}
