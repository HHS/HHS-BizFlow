package gov.hhs.usas.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import gov.hhs.usas.rest.model.CognosReport;
import gov.hhs.usas.rest.model.USASCredentials;
import gov.hhs.usas.rest.model.USASRequest;
import gov.hhs.usas.rest.model.USASResponse;
import gov.hhs.usas.rest.report.service.Properties;

/**
 * @author pvirdi
 *This class acts as REST Client for USA Staffing Cognos - 
 *Prepares Request & Response for REST web service calls for 
 *authentication and to get report data. 
 */
@Configuration
public class CognosRESTClient
{
	private static final Logger log = LoggerFactory.getLogger(CognosRESTClient.class);
	@Autowired
	private Properties properties;
	@Autowired
	private USASRequest usasRequest;
	@Autowired
	private USASResponse usasResponse;
	@Autowired
	private USASCredentials credentials;
/*//	@Value("${xml.data.login.template}")
	private String xmlDataLoginTemplate;
//	@Value("${xml.data.report.template}")
	private String xmlDataReportTemplate;	
//	@Value("${path.logon}")
	private String logonPath;
//	@Value("${path.logoff}")
	private String logoffPath;
//	@Value("${path.reportdata}")
	private String reportDataPath;*/
	private CookieManager manager;


	public CognosRESTClient(){
		manager = new CookieManager();
		//Setting up HTTPS protocol compatible with Java 7
		System.setProperty("https.protocols", "TLSv1.1,TLSv1.2");
		try
		{
			SSLContext ctx = SSLContext.getInstance("TLSv1.2");
			ctx.init(null, null, null);
			SSLContext.setDefault(ctx);
		}
		catch (NoSuchAlgorithmException e)
		{
			log.error(e.getMessage() + "::" + e.getCause());
		}
		catch (KeyManagementException e)
		{
			log.error(e.getMessage() + "::" + e.getCause());
		}
	}

	/**
	 * Logs into the USA Staffing Cognos server, requests report data
	 * for specific report and then logs off.
	 * @param report
	 * @return USASResponse
	 */
	public USASResponse sendReportDataRequest(CognosReport report)
	{
		boolean isConnected = sendLogonRequest();

		if(isConnected){
			String vacancyReportURL = this.usasRequest.getServerURL() + properties.getReportDataPath() + report.getId();
//			this.usasRequest.setPOSTParameters(this.xmlDataReportTemplate, report.getPrompt());
			this.usasRequest.setPOSTParameters(properties.getXmlDataReportTemplate(), report.getPrompt());
			try
			{
				URL url = new URL(vacancyReportURL);
				log.info("\nPreparing 'POST' request to " + report.getName() + " Report URL : " + url);
				log.info("Post parameters : " + this.usasRequest.getPOSTParameters());

				HttpURLConnection con = (HttpURLConnection)url.openConnection();

				con.setRequestMethod(this.usasRequest.getRequestMethod());
				con.setRequestProperty(this.usasRequest.getUserAgentProperty(), this.usasRequest.getUserAgent());
				con.setRequestProperty(this.usasRequest.getAcceptLanguageProperty(), this.usasRequest.getAcceptLanguage());
				con.setRequestProperty(this.usasRequest.getContentTypeProperty(), this.usasRequest.getContentType());
				con.setRequestProperty(this.usasRequest.getCookieProperty(), this.usasRequest.getCookie());

				con.setDoOutput(true);
				OutputStream os = con.getOutputStream();
				os.write(this.usasRequest.getPOSTParameters().getBytes());
				os.flush();
				os.close();

				con.connect();

				log.info("Report Data Response : " + con.getResponseCode() + "::" + con.getResponseMessage());
				if (con.getResponseCode() == 200)
				{
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

					StringBuffer response = new StringBuffer();
					String inputLine;
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					this.usasResponse.setResponseCode(con.getResponseCode());
					this.usasResponse.setResponse(response.toString());
					this.usasResponse.setErrorMessage("Status OK");

					log.info("Report Data Result:: " + this.usasResponse.getResponse());
				}
				else
				{
					this.usasResponse.setErrorMessage("Error requesting Report Data from USAS::" + con.getResponseCode() + ":" + con.getResponseMessage() + "::" + con.getErrorStream().toString());
				}
			}catch (MalformedURLException e){
				this.usasResponse.setErrorMessage("Error requesting Report Data from USAS::" + e.getMessage() + "::" + e.getCause());
			}catch (IOException e){
				this.usasResponse.setErrorMessage("Error requesting Report Data from USAS::" + e.getMessage() + "::" + e.getCause());
			}catch (Exception e){
				this.usasResponse.setErrorMessage("Error requesting Report Data from USAS::" + e.getMessage() + "::" + e.getCause());
			}finally{
				log.info(this.usasResponse.getErrorMessage());
				sendLogoffRequest();
			}}else{
				this.usasResponse.setResponseCode(400);
				this.usasResponse.setErrorMessage("Error connecting to USA Staffing. Please check the logs.");
			}
		return this.usasResponse;
	}

	/**
	 * Prepares and sends remote request to login to USA Staffing Cognos server
	 */
	@SuppressWarnings("finally")
	public boolean sendLogonRequest()
	{
		//String logonURL = this.usasRequest.getServerURL() + "/rds/auth/logon";
		log.info("\nConnecting to USAS Cognos server...");
		boolean isConnected = false;
		String logonURL = this.usasRequest.getServerURL() + properties.getLogonPath();
		this.usasRequest.setRequestMethod("POST");
//		this.usasRequest.setPOSTParameters(this.xmlDataLoginTemplate, this.credentials);
		this.usasRequest.setPOSTParameters(properties.getXmlDataLoginTemplate(), this.credentials);
		try
		{			
			this.manager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
			CookieStore cookieJar = this.manager.getCookieStore();
			CookieHandler.setDefault(this.manager);

			URL url = new URL(logonURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();

			con.setRequestMethod(this.usasRequest.getRequestMethod());
			con.setRequestProperty(this.usasRequest.getUserAgentProperty(), this.usasRequest.getUserAgent());
			con.setRequestProperty(this.usasRequest.getAcceptLanguageProperty(), this.usasRequest.getAcceptLanguage());
			con.setDoOutput(true);
			OutputStream os = con.getOutputStream();
			os.write(this.usasRequest.getPOSTParameters().getBytes());
			os.flush();
			os.close();
			con.connect();
			con.getContent();			

			if (con.getResponseCode() == 200)
			{
				log.info("Connected");
				createCookieString(cookieJar);//store the cookies for subsequent requests
				isConnected = true;
				//TO DO - Delete
				/*BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				StringBuffer response = new StringBuffer();
				String inputLine;
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();*/
			}
			else
			{
				log.info("Error connecting to USAS::" + con.getResponseCode() + ":" + con.getResponseMessage() + "::" + con.getErrorStream().toString());
			}
		}
		catch (MalformedURLException e)
		{
			log.error("Error connecting to USAS::" + e.getMessage() + "::" + e.getCause());
		}
		catch (IOException e)
		{
			log.error("Error connecting to USAS::" + e.getMessage() + "::" + e.getCause());
		}
		catch (Exception e)
		{
			log.error("Error connecting to USAS::" + e.getMessage() + "::" + e.getCause());
		}finally{
			return isConnected;
		}
	}

	/**
	 * Prepares and sends remote request to logoff from USA Staffing Cognos server
	 */
	public void sendLogoffRequest()
	{
		//String logoffURL = this.usasRequest.getServerURL() + "/rds/auth/logoff";
		String logoffURL = this.usasRequest.getServerURL() + properties.getLogoffPath();
		this.usasRequest.setRequestMethod("GET");
		try
		{
			URL url = new URL(logoffURL);
			HttpURLConnection con = (HttpURLConnection)url.openConnection();

			con.setRequestMethod(this.usasRequest.getRequestMethod());
			con.setRequestProperty(this.usasRequest.getUserAgentProperty(), this.usasRequest.getUserAgent());
			con.setRequestProperty(this.usasRequest.getAcceptLanguageProperty(), this.usasRequest.getAcceptLanguage());
			con.setRequestProperty(this.usasRequest.getCookieProperty(), this.usasRequest.getCookie());

			log.info("\nDisconnecting from USAS Cognos server::" + con.getResponseCode() + "::" + con.getResponseMessage());
		}
		catch (MalformedURLException e)
		{
			log.error("Error disconnecting from USAS::" + e.getMessage() + "::" + e.getCause());
		}
		catch (IOException e)
		{
			log.error("Error disconnecting from USAS::" + e.getMessage() + "::" + e.getCause());
		}
	}

	/**
	 * @param cookieStore
	 * Manages the cookie to maintain current session
	 */
	private void createCookieString(CookieStore cookieStore)
	{
		StringBuffer cookieString = new StringBuffer();
		for (int i = 0; i < cookieStore.getCookies().size(); i++)
		{
			if (i > 0) {
				cookieString.append(";");
			}
			cookieString.append(((HttpCookie)cookieStore.getCookies().get(i)).toString());
		}
		this.usasRequest.setCookie(cookieString.toString());
	}

	public USASResponse getUsasResponse()
	{
		return this.usasResponse;
	}
}

