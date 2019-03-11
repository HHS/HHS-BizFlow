<%@ page import="com.hs.sso.services.SingleSignOn" %>
<%@ page import="org.springframework.web.context.WebApplicationContext" %>
<%@ page import="org.springframework.web.context.support.WebApplicationContextUtils" %>
<%
	SingleSignOn singleSignOn = null;
	try
	{
		WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(application);
		if(null != context) {
			singleSignOn = (SingleSignOn)context.getBean("singleSignOnService");
			if( null != singleSignOn) {
				response.sendRedirect(singleSignOn.getSsoFailureUrl());
				return;
			}
		}
	} catch(Exception ex) {
		ex.printStackTrace();
		response.sendRedirect("/");
	}
%>
