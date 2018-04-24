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

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	private static Log log = LogFactory.getLog(CognosRESTClient.class);
	@Autowired
	private Properties properties;
	@Autowired
	private USASRequest usasRequest;
	@Autowired
	private USASResponse usasResponse;
	@Autowired
	private USASCredentials credentials;
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

		if(sendLogonRequest().equalsIgnoreCase(properties.getResponseCodeSuccess())){
			String vacancyReportURL = this.usasRequest.getServerURL() + properties.getReportDataPath() + report.getId();
			this.usasRequest.setPOSTParameters(properties.getXmlDataReportTemplate(), report.getPrompt());
			try
			{
				URL url = new URL(vacancyReportURL);

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

				if (con.getResponseCode() == properties.getHttpStatusOk())
				{
					BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));

					StringBuffer response = new StringBuffer();
					String inputLine;
					while ((inputLine = in.readLine()) != null) {
						response.append(inputLine);
					}
					in.close();

					this.usasResponse.setResponse(response.toString());
					
					//verify response if it contains 'No Data Available', send an error
					if(response.toString().contains("No Data Available")){
						this.usasResponse.setResponseCode(properties.getHttpSuccessNoContent());
						this.usasResponse.setErrorMessage(properties.getNoDataException());
					}else{
						this.usasResponse.setResponseCode(con.getResponseCode());						
						this.usasResponse.setErrorMessage(properties.getResponseCodeSuccess());
					}
				}
				else
				{
					this.usasResponse.setErrorMessage(properties.getReportDataException() + con.getResponseCode() + ":" + con.getResponseMessage());
				}
			}catch (MalformedURLException e){
				this.usasResponse.setErrorMessage(properties.getReportDataException() + e.getMessage() + "::" + e.getCause());
			}catch (IOException e){
				this.usasResponse.setErrorMessage(properties.getReportDataException() + e.getMessage() + "::" + e.getCause());
			}catch (Exception e){
				this.usasResponse.setErrorMessage(properties.getReportDataException() + e.getMessage() + "::" + e.getCause());
			}finally{
				log.info(this.usasResponse.getErrorMessage());
				sendLogoffRequest();
			}
		}else{
			this.usasResponse.setResponseCode(properties.getHttpClientErrorBadRequest());
			this.usasResponse.setErrorMessage(properties.getConnectionException());
		}
		return this.usasResponse;
	}

	/**
	 * Prepares and sends remote request to login to USA Staffing Cognos server
	 */
	@SuppressWarnings("finally")
	public String sendLogonRequest()
	{
		log.info("\nConnecting to USAS Cognos server...");
		String connectionResponse = "";
		String logonURL = this.usasRequest.getServerURL() + properties.getLogonPath();
		this.usasRequest.setRequestMethod("POST");
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

			if (con.getResponseCode() == properties.getHttpStatusOk())
			{
				log.info("Connection successful");
				createCookieString(cookieJar);//store the cookies for subsequent requests
				connectionResponse = properties.getResponseCodeSuccess();
			}
			else
			{
				log.info(properties.getConnectionException() + con.getResponseCode() + ":" + con.getResponseMessage());
				connectionResponse = properties.getResponseCodeConnectionError();
			}
		}
		catch (MalformedURLException e)
		{
			log.error(properties.getConnectionException() + e.getMessage() + "::" + e.getCause());
			connectionResponse = properties.getResponseCodeConnectionError();
		}
		catch (IOException e)
		{
			log.error(properties.getConnectionException() + e.getMessage() + "::" + e.getCause());
			connectionResponse = properties.getResponseCodeConnectionError();
		}
		catch (Exception e)
		{
			log.error(properties.getConnectionException() + e.getMessage() + "::" + e.getCause());
			connectionResponse = properties.getResponseCodeConnectionError();
		}finally{
			return connectionResponse;
		}
	}

	/**
	 * Prepares and sends remote request to logoff from USA Staffing Cognos server
	 */
	public void sendLogoffRequest()
	{
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
			log.error("An error occurred while trying to disconnect from USA Staffing server. " + e.getMessage() + "::" + e.getCause());
		}
		catch (IOException e)
		{
			log.error("An error occurred while trying to disconnect from USA Staffing server. " + e.getMessage() + "::" + e.getCause());
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

