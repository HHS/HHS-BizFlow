<%@ page import="java.io.StringWriter" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="org.springframework.security.web.WebAttributes" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" dir="ltr">
<head>
	<title>BizFlow Logout Error</title>
</head>
<!-- NOTES: keep the style in a separate file won't work because after logout web browser may not be able to access to the css file. //-->
<style>
body {
	color: #000000;
	background-color: #006A9A;
}
div .info, .warning, .error {
	margin-top: 80px;
		margin-left: auto;
		margin-right: auto;
	border-radius: 15px;
	width: 80%;
	border: 1px solid;
	padding:15px 10px 15px 10px;
		font-size: 20px;
		text-align: center;
}
.info {
	color: #00529B;
	background-color: #BDE5F8;
}
.warning {
	color: #9F6000;
	background-color: #FEEFB3;
}
.error {
	color: #D8000C;
	background-color: #FECACA;
}
	a {
	font-size: 20px;
}
	a span {
	font-size: 20px;
}
</style>
<body>

    <div style="margin-top:180px; width:100%; text-align: center">

       <img alt="bizlogo" src="/bizflow/themes/oceanblue/langs/en/bizlogo.gif" title="bizlogo"/>

        <div class="info">
		
			<div><h2 class="label label-green">Single Sign On Error</h2></div>
			<p class="quiet large">An error occurred.</p>
			<div class="post-body">
			<%
				// Load exception set from Spring Security unless set from web.xml error handler
				if (exception == null) {
					exception = (Throwable) request.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
				}
			%>
			<% if (exception != null) { %>
				<strong>Message:</strong><br>
				<%= exception.getMessage() %>
			<% } %>
			</div>
		</div>
    </div>

</body>
</html>

