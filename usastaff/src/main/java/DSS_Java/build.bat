@echo off

rem Licensed Materials - Property of IBM
rem IBM Cognos Products: DOCS
rem (C) Copyright IBM Corp. 2008, 2009
rem US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with
rem IBM Corp.

rem Copyright (C) 2008 Cognos ULC, an IBM Company. All rights reserved.
rem Cognos (R) is a trademark of Cognos ULC, (formerly Cognos Incorporated).

rem Build Java files in directory AuthenticationPrompt

rem You must set a JAVA_HOME variarable for this script to run

set JAVA_HOME=c:/jdk6
set CRN_HOME=../../../../

if ("%JAVA_HOME%") == ("") goto defineJAVA

echo Using JAVA_HOME=%JAVA_HOME%

rem Build the CLASSPATH required to build Java files in
rem the directory AuthenticationPrompt

set JAVAC=%JAVA_HOME%/bin/javac
set JAR_HOME=%CRN_HOME%sdk/java/lib

rem Create the Classpath

set CLASSPATH=.
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/axis.jar
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/commons-discovery-0.2.jar
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/commons-logging-1.1.jar
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/log4j-1.2.8.jar
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/jaxrpc.jar
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/saaj.jar
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/wsdl4j-1.5.1.jar
set CLASSPATH=%CLASSPATH%;../common_class

echo Compiling Files....

rem Compile Java files
"%JAVAC%" -classpath "%CLASSPATH%" *.java

goto end

:defineJAVA
echo You must define a JAVA_HOME environment variable pointing to your Java Development Kit location
goto end

:end
