@echo off

rem Run the program at the command-line.

::set "JAVA_HOME=C:\Program Files\Java\jdk1.7.0_80"
set "JAVA_HOME=C:\Program Files\Java\jdk1.8.0_131"
set JAR_HOME=.

:: Build the CLASSPATH required to run genericAuthenticationPrompt.class
set CLASSPATH=.
::set CLASSPATH=%CLASSPATH%;../classes
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/ojdbc6.jar
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/sqljdbc4.jar
set CLASSPATH=%CLASSPATH%;%JAR_HOME%/jdbcconn.jar

rem Run program
"%JAVA_HOME%"\bin\java.exe -classpath %CLASSPATH% JDBCConn %1 %2 %3 %4 %5 %6

goto end

:end