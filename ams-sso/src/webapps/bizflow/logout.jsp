<%@ page import="com.hs.bf.web.beans.*, java.util.*, java.io.*, com.hs.frmwk.web.util.*" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/bizflow.tld" prefix="bf" %>

<%! static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger("JSP.bizflow"); %>

<%
long startedTime = 0;
if (logger.isDebugEnabled()) startedTime = System.currentTimeMillis();
%>

<jsp:useBean id="hwSessionFactory" class="com.hs.bf.web.beans.HWSessionFactory" scope="application"/>
<jsp:useBean id="res" class="com.hs.bf.web.xslt.resource.ResourceBag" scope="application"/>
<jsp:useBean id="bizflowProps" class="com.hs.bf.web.props.Properties" scope="application"/>
<jsp:useBean id="hwSessionInfo" class="com.hs.bf.web.beans.HWSessionInfo" scope="session"/>
<jsp:useBean id="hwini" class="com.hs.frmwk.common.ini.IniFile" scope="session"/>
<jsp:useBean id="sessionUtil" class="com.hs.frmwk.web.util.SessionUtil" scope="session"/>
<jsp:useBean id="hwiniSystem" class="com.hs.frmwk.common.ini.IniFile" scope="application"/>

<bf:parameter id="removeWebSession" name="removeWebSession" value="y" valuePattern="Word"/>

<%
String browser = (String) session.getAttribute("BrowserName");
String hwauVersion = bizflowProps.getProperty("com.hs.bf.web.hwauVersion");

String redirectURL = null;
String closeOnLoad = request.getParameter("close");
String loginType = request.getParameter("loginType");
String language = (String) session.getAttribute("Language");
language = (language == null || language == "") ? "en" : language;

if( "SPNEGOSSO".equals(loginType) || "BIZFLOWSSO".equals(loginType))
{
	closeOnLoad = "n";
	String charSet = (String) session.getAttribute("LangCharSet");
	//HHS BizFlowSSO Bugfix - When to click Logout link, BizFlow informs BizFlowSSO the logout event.
	String bizFlowSSOLogoutURL = application.getInitParameter("BizFlowSSOLogoutURL"); 
	bizFlowSSOLogoutURL = (bizFlowSSOLogoutURL == null || bizFlowSSOLogoutURL == "") ? "" : bizFlowSSOLogoutURL;
	if (!"".equals(bizFlowSSOLogoutURL)) {
		redirectURL = bizFlowSSOLogoutURL;	
	} else {
		redirectURL = "./msg.jsp?language="+language+"&charSet="+charSet+"&resid=MSG_LOG_OUT";
	}
}

HWSession hwSession = hwSessionFactory.newInstance();
boolean isThinClientMode = "True".equalsIgnoreCase(hwiniSystem.getValue("WORK_AREA_DEFAULT", "PURE_THIN_CLIENT_MODE"))
        || "PURE_THIN_CLIENT_MODE".equals(session.getAttribute("UserClientMode"));
boolean useClientModuleInstallation =  !"False".equalsIgnoreCase(hwiniSystem.getValue("WORK_AREA_DEFAULT", "CLIENT_MODULE_INSTALLATION"));

// administrator case
if ("9999999999".equalsIgnoreCase(hwSessionInfo.get("USERID")) &&
	!"False".equalsIgnoreCase(hwiniSystem.getValue("WORK_AREA_DEFAULT", "PURE_THIN_CLIENT_MODE")))
{
	isThinClientMode = true;
}

try {
	sessionUtil.updateIni(hwini);
	hwini.save(new FileWriter((String)session.getAttribute("useriniFilePath")));
	hwSession.uploadUserINIFile(hwSessionInfo.toString());
	hwSession.logOut(hwSessionInfo.toString());
} catch (Exception e2) {}

if("y".equals(removeWebSession))
{
    try {
        ArrayList attrNames = new ArrayList();

        synchronized (session)
        {
            Enumeration sessionAttrNames = session.getAttributeNames();
            while (sessionAttrNames.hasMoreElements())
            {
                String name = (String) sessionAttrNames.nextElement();
                attrNames.add(name);
            }
        }

        int attrCount = attrNames.size();

        for (int i = 0; i != attrCount; ++i)
        {
            String name = (String) attrNames.get(i);

            if (session.getAttribute(name) != null)
            {
                try {
                    Object temp = (Object) session.getAttribute(name);
                    temp = null;
                    session.removeAttribute(name);
                } catch (Exception e3) {}
            }
        }

        session.invalidate();
    } catch (Exception e2) {e2.printStackTrace();}
}
%>

<HTML lang="<%=language%>">
<head>
<title></title>
<script language=javascript>
<!--
function window_onload()
{
<% if ("y".equals(closeOnLoad) && !isThinClientMode) { %>
//	var au = null;
//
//    try {
//        if (BrowserDetect.isExplorer())
//        {
//            au = HWAUCtrl;
//        }
//        else
//        {
//            au = document.HWAUCtrl;
//        }
//    }catch(e) {
//    }
//
//	if ('undefined' != typeof(au) && null != au)
//	{
//		if (BrowserDetect.isExplorer())
//		{
//			try
//			{
//				au.RestartBrowser("");
//			}
//			catch(e)
//			{}
//		}
//		else
//		{
//			//au.Invoke1("RestartBrowser", 8, "");
//			window.close();
//		}
//	}
//	else
//	{
//		top.window.close();
//	}

	top.window.close();

<% } else if ("y".equals(closeOnLoad)) { %>
	top.window.close();
<% } else if(redirectURL == null){ %>
	// begin of bug22930: default login url on web session expiration page.
	var url = "<%="".equals(hwiniSystem.getValue("AUTHENTICATION", "LOGINURL")) ? bizflowProps.getProperty("com.hs.bf.web.default.login.url") : hwiniSystem.getValue("AUTHENTICATION", "LOGINURL")%>";
	if (null == url || "" == url || "null" == url) url = "./";
	top.location.href = url;
	// end of bug22930: default login url on web session expiration page.
<% } else {%>
	if (parent && parent.location && parent.location.href.indexOf("forcelogout.jsp") > 0) {
        // Use current window to run logout API. Do not use top window. The top window is supposed to run 'window.close()' in 10 secs.
		location.href = "<%=redirectURL%>";
	} else {
		top.location.href = "<%=redirectURL%>";
	}
<%}%>
}
//-->
</script>
</head>
<body onload="window_onload();">

<%--<% if (!isThinClientMode) { %>--%>
<%--<% if ("NS".equals(browser)) { %>--%>
	<%--<EMBED TYPE="application/x-ctrlwrapper" name="HWAUCtrl" --%>
		<%--WIDTH="1" HEIGHT="2" --%>
		<%--clsid="CLSID:427BD09A-B354-4AF3-89CC-7EB3B315554B"--%>
		<%--ExplicitCreate="true">--%>
<%--<% } else if ("IE".equals(browser)) { %>--%>
	<%--<OBJECT ID="HWAUCtrl" --%>
		<%--CLASSID="CLSID:427BD09A-B354-4AF3-89CC-7EB3B315554B"--%>
<%--<%if(useClientModuleInstallation) {%>--%>
        <%--CodeBase="<%=request.getContextPath()%>/controls/hwau.cab#version=<%=hwauVersion%>"--%>
<%--<%}%>--%>
        <%--WIDTH="1" HEIGHT="1" VIEWASTEXT>--%>
	<%--</OBJECT>--%>
<%--<% } %>--%>
<%--<% } %>--%>
</body>
</html>

<% if (logger.isDebugEnabled()) logger.debug(request.getRequestURI() + " " + (System.currentTimeMillis() - startedTime) + " ms"); %>
