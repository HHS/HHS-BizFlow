@echo off

rem Licensed Materials - Property of IBM
rem IBM Cognos Products: DOCS
rem (C) Copyright IBM Corp. 2008, 2009
rem US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with
rem IBM Corp.

rem Copyright (C) 2008 Cognos ULC, an IBM Company. All rights reserved.
rem Cognos (R) is a trademark of Cognos ULC, (formerly Cognos Incorporated).

rem Run genericAuthenticationPrompt.class

::set JAVA_HOME=../../../../bin/jre/7.0/bin/java.exe
::set CRN_HOME=../../../../
::set JAR_HOME=%CRN_HOME%sdk/java/lib

::set "JAVA_HOME=C:\Program Files\Java\jdk1.7.0_80"
set "JAVA_HOME=C:\Program Files\Java\jdk1.8.0_131"
set JAR_HOME=./lib

rem Build the CLASSPATH required to run genericAuthenticationPrompt.class

set CLASSPATH=.
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/axis.jar
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/commons-discovery-0.2.jar
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/commons-logging-1.1.jar
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/log4j-1.2.8.jar
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/jaxrpc.jar
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/saaj.jar
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/wsdl4j-1.5.1.jar
::set CLASSPATH=%CLASSPATH%;../common_class
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/usastaffdss.jar

rem Run genericAuthenticationPrompt.class

::"%JAVA_HOME%" -classpath %CLASSPATH% genericAuthenticationPrompt %1 %2 %3 %4
::"%JAVA_HOME%"\bin\java.exe -classpath %CLASSPATH% DSS_Java.genericAuthenticationPrompt -u https://data.stage.usastaffing.gov/ibmcognos/bi/v1/disp -l

"%JAVA_HOME%"\bin\java.exe -classpath %CLASSPATH% DSS_Java.DSS_JavaUI

goto end

:end