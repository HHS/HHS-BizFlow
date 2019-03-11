<%@ page import="com.hs.sso.services.SingleSignOn" %>
<%@ page import="com.hs.sso.vo.UserAuth" %>
<%@ page import="org.apache.commons.logging.LogFactory" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.saml.SAMLCredential" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%@ page import="org.springframework.security.core.userdetails.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr">

<%! static org.apache.commons.logging.Log logger = LogFactory.getLog("JSP.bizflow-sso"); %>

<%
    /* 
	*	1. Global Options: Single Sign-On Option = BIZFLOWSSO
	*	2. Please add the IP address of Web server to server.ini
	*		[WAS] TrustedServer.<N>=<IP>
	*	3. Server Configuration > Trusted Server : Set up Master Password and Download Security Key to /bizflow/WEB-INF/bizflow.cert
	*	4. Review BizFlowCertFilePath in web.xml
	*	5. Restart BizFlow Server.
    */
%>

<%
	long startedTime = 0;
	if (logger.isDebugEnabled()) startedTime = System.currentTimeMillis();

	SingleSignOn singleSignOn = null;
	String userId = "";
	String sso_clientip = request.getRemoteAddr();
	String sessionInfoXML = "";
	String ssoLoginUrl = "";
	String ssoSuccessUrl = "";
	String ssoFailureUrl = "";

	String userIdEncrypted = "";
	String sessionInfoXmlEncrypted = "";

	String errorMessage = "";
	try
	{
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		if(null != context) {
			singleSignOn = (SingleSignOn)context.getBean("singleSignOnService");
			if(singleSignOn != null) {
				String authenticationType = "ADFS2";
				try {
					authenticationType = context.getEnvironment().getActiveProfiles()[0];
				} catch(Exception e) {
					e.printStackTrace();
				}
				Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
				if(null != authentication) {
					if("ADFS2".equalsIgnoreCase(authenticationType)) {
						SAMLCredential credential = (SAMLCredential) authentication.getCredentials();
						if(null != credential && null != credential.getNameID()) {
							userId = credential.getNameID().getValue();
						}
					} else  if("CASSO".equalsIgnoreCase(authenticationType)) {
						User user = (User)authentication.getPrincipal();
						if(null != user) {
							String hRequestHeader = singleSignOn.getPrincipalRequestHeader();
							String hUserId = request.getHeader(hRequestHeader);
							userId = user.getUsername();
							if(hUserId == null || !hUserId.equals(userId)) {
								userId = hUserId;
							}
						}
						// MetLife SM adds domain name with @.  Remove it here.
						String cutOffCharacters = singleSignOn.getCutOffCharacters();
						if((cutOffCharacters != null) && (cutOffCharacters.length() > 0)) {
							int index = -1;
							if (userId != null && (index = userId.indexOf(cutOffCharacters)) != -1) {
								userId = userId.substring(0, index);
							}
						}
					}
					if(null != userId && userId.length() > 0) {
						UserAuth userAuth = (UserAuth) session.getAttribute(UserAuth.SESSION_ATTRIBUTE_ID + userId);
						if (userAuth == null) {
							userAuth = singleSignOn.checkAccess(userId, sso_clientip);
							if(null != userAuth) {
								session.setAttribute(UserAuth.SESSION_ATTRIBUTE_ID + userId, userAuth);
								sessionInfoXML = userAuth.getSessionInfoXML();
							}
						} else {
							sessionInfoXML = singleSignOn.loginBySSO(userId, sso_clientip);
							userAuth.setSessionInfoXML(sessionInfoXML);
							session.setAttribute(UserAuth.SESSION_ATTRIBUTE_ID + userId, userAuth);
						}
					} else {
						if (logger.isDebugEnabled()) {
							logger.debug("JSP.bizflow-sso: cannot get userId.");
						}
						errorMessage = "SSO Module cannot get userId.";
					}
				} else {
					if (logger.isDebugEnabled()) {
						logger.debug("JSP.bizflow-sso: Authentication is null.");
					}
					errorMessage = "SSO Module cannot get authentication object.";
				}
			} else {
				if (logger.isDebugEnabled()) {
					logger.debug("JSP.bizflow-sso: singleSignOn is null.");
				}
				errorMessage = "SSO Module is not loaded.";		
			}
		} else {
			if (logger.isDebugEnabled()) {
				logger.debug("JSP.bizflow-sso: context is null.");
			}
			errorMessage = "SSO Context is not loaded.";		
		}
	} catch(Exception ex) {
		ex.printStackTrace();
		errorMessage = ex.toString();		
	}


	if( null != singleSignOn) {
		ssoLoginUrl = singleSignOn.getSsoLoginUrl();
		ssoSuccessUrl = singleSignOn.getSsoSuccessUrl();
		ssoFailureUrl = singleSignOn.getSsoFailureUrl();

		if((null != sessionInfoXML) && (sessionInfoXML.length() > 0) && (null != userId) && (userId.length() > 0)) {
			userIdEncrypted = com.hs.frmwk.web.encoding.Cipher01.encrypt(userId);
			sessionInfoXmlEncrypted = com.hs.frmwk.web.encoding.Cipher01.encrypt(sessionInfoXML);
		}
	}
%>

<HTML>
<HEAD>
	<TITLE>BizFlow SSO</TITLE>
	<SCRIPT LANGUAGE="javascript">
	<!--
		function window_onload() {
			if ("<%=errorMessage%>" != "") {
				alert("<%=errorMessage%>");
				location.href = "<%=ssoFailureUrl%>";
				return;
			} else if('<%=sessionInfoXML%>' == '') {
				location.href = "<%=ssoFailureUrl%>";
				return;
			}
			document.frmLogin.submit();
		}
	//-->
	</SCRIPT>
</HEAD>
<BODY onload="window_onload()">
<FORM NAME="frmLogin" METHOD="post" ACTION="<%=ssoLoginUrl%>">
	<input type="hidden" name="loginType" value="BIZFLOWSSO">
	<input type="hidden" name="loginID" value="<%=userIdEncrypted%>">
	<input type="hidden" name="clientip" value="<%=sso_clientip%>">
	<input type="hidden" name="sessionInfoXML" value='<%=sessionInfoXmlEncrypted%>'>
	<input type="hidden" name="returnURL" value="<%=ssoSuccessUrl%>">
	<input type="hidden" name="errorURL" value="<%=ssoFailureUrl.substring(ssoFailureUrl.lastIndexOf("/") + 1)%>">
</FORM>
</BODY>
</HTML>
<% if (logger.isDebugEnabled()) logger.debug("JSP.bizflow-sso:" +  (System.currentTimeMillis() - startedTime)); %>
