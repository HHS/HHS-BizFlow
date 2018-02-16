#!/bin/sh
#
#  Licensed Materials - Property of IBM
#
#  IBM Cognos Products: DOCS
#
#  (C) Copyright IBM Corp. 2009, 2010
#
#  US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with
#  IBM Corp.
#
#
# Run the samples at the command-line without a GUI.

# REMOVE this when you edit this file.
echo You MUST edit this file before you can run this application.

# CHANGE the following environment variables to point to
# the Java Development Kit and AXIS 1.4 library location.


JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_76.jdk/Contents/Home
JAR_HOME=./lib

# Build the CLASSPATH required
CLASSPATH=
#for dir in ../common_class; do
#  CLASSPATH="$CLASSPATH:$dir"
#done
for jar in axis commons-discovery-0.2 commons-logging-1.1 log4j-1.2.8 jaxrpc \
	saaj wsdl4j-1.5.1 usastaffdss ; do
  CLASSPATH="$CLASSPATH:$JAR_HOME/$jar.jar"
done

# Run genericAuthenticationPrompt
#$JAVA_HOME/bin/java -classpath "$CLASSPATH" genericAuthenticationPrompt $1 $2 $3 $4
#$JAVA_HOME/bin/java -classpath $CLASSPATH DSS_Java.genericAuthenticationPrompt -u https://data.stage.usastaffing.gov/ibmcognos/bi/v1/disp -l

$JAVA_HOME/bin/java -classpath $CLASSPATH DSS_Java.DSS_JavaUI