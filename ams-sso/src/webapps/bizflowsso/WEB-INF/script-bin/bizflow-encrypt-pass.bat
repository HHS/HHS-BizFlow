@echo off

set CMD_LINE_ARGS=
:setArgs
if ""%0""=="""" goto doneSetArgs
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %0
shift
goto setArgs
:doneSetArgs

set JS_ENC_CMD_CLASS=com.hs.frmwk.web.encoding.Cipher01

set EXP_CLASSPATH=%CLASSPATH%
REM
REM Loop through and add all class jars to exp_classpath
REM

REM
REM Set the java command
REM
REM If "..\java\bin\java.exe" exists then use it
REM

if exist "..\java\bin\java.exe" goto setLocalJava

goto setStandardJava

:setLocalJava

set JAVA_HOME="..\java"
set PATH=..\java\bin;%PATH%

goto doneJava
:setStandardJava

if "%JAVA_HOME%"=="" goto warnJava

goto doneJava
:warnJava

echo "WARNING: Did not find a JAVA_HOME environment variable setting. Script will continue."

:doneJava

set EXP_CLASSPATH=..\lib\hwweb.jar;..\lib\rijndael-api.jar;.
java  -classpath "%EXP_CLASSPATH%" "%JS_ENC_CMD_CLASS%" %CMD_LINE_ARGS% 
