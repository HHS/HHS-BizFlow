@echo off

set BASEDIR=%~dp0%
echo using BASEDIR of %BASEDIR%
cd %BASEDIR%

:: REMOVE this when you edit this file.
echo ============================
echo WARNING: You MUST edit this file before you can run this application.
echo ============================

::-----------------------------------------------------------
:: CHANGE the following environment variables to point to
:: the Java Development Kit and dependency library location.
::-----------------------------------------------------------
::set JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_76.jdk/Contents/Home
set "JAVA_HOME=C:\Program Files\Java\jdk1.7.0_80"
set LIB_DIR=%BASEDIR%\lib
set CONF_DIR=%BASEDIR%\conf
set EXECJAR=%BASEDIR%\usasdss-0.0.1-SNAPSHOT.jar

::-----------------------------
:: Build the CLASSPATH required
::-----------------------------
set CLASSPATH=%CLASSPATH%;.;%BASEDIR%;%LIB_DIR%\*;%CONF_DIR%;%EXECJAR%

::debug - show classpath
::echo JAVA_HOME = %JAVA_HOME%
::echo CLASSPATH = %CLASSPATH%

::-----------------------------
:: Run application
::-----------------------------
"%JAVA_HOME%\bin\java" -jar %EXECJAR% %1 %2 %3 %4 %5
::%JAVA_HOME%\bin\java -classpath %CLASSPATH% org.springframework.boot.loader.JarLauncher  %1 %2 %3 %4 %5
