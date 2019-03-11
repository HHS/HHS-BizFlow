<%@ page language="java" import="java.util.*" %> 
<%@ page import = "java.util.ResourceBundle" %>
<% 
	ResourceBundle resource = ResourceBundle.getBundle("bizflow-sso");
	String ssoRedirectUrl = "";
	try {
		ssoRedirectUrl = resource.getString("sso.logout.redirectURL");
		if (ssoRedirectUrl == null) {ssoRedirectUrl = "";}
	} catch (Exception e) {
		ssoRedirectUrl = "";
	}
%>
<html>
<head>
	<title>BizFlow SSO Logout</title>
	<SCRIPT LANGUAGE="javascript">
	<!--
		function window_onload() {
			if ("<%=ssoRedirectUrl%>" != "") {
				setTimeout(function(){ goBackToSSO("<%=ssoRedirectUrl%>"); }, 1000);
				return;
			}
			document.frmLogin.submit();
		}
		
		function goBackToSSO(url) {
			location.href = url;
		}
		
	//-->
	</SCRIPT>	
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
<body onload="window_onload()">
    <div style="margin-top:180px; width:100%; text-align: center">
       <img alt="bizlogo" src="/bizflow/themes/oceanblue/langs/en/bizlogo.gif" title="bizlogo"/>
        <div class="info">
            You have been logged out.
            <p>
            <a href="/bizflow/" title="Back to Login">Back to Login</a>
            </p>
        </div>
    </div>
</body>
</html>
