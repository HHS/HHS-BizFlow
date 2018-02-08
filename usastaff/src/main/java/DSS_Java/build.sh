#!/bin/sh
#
# Licensed Materials - Property of IBM
#
# IBM Cognos Products: DOCS
#
# (C) Copyright IBM Corp. 2009, 2010
#
# US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with
# IBM Corp.
#
#
# Build the Java samples.

# REMOVE this when you edit this file.
echo You MUST edit this file before you can compile this application.


#*  *  *  *  *  *  *  *
#CHANGE the following environment variables to point to the
#Java Development Kit and AXIS 1.4 library location.
#*  *  *  *  *  *  *  *

JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.8.0_131.jdk/Contents/Home
JAR_HOME=/Users/syang/Desktop/work/proj/HHS/dev/integration/USAStaff/DSS_Java/src/DSS_Java/lib


if [ "$CRN_HOME" = "" ] ; then
	CRN_HOME=/user/ibm/cognos/c10
fi
if [ "$JAVA_HOME" = "" ] ; then
	JAVA_HOME=/c/j2sdk1.6
fi

#JAR_HOME=$CRN_HOME/sdk/java/lib

JAVAC=$JAVA_HOME/bin/javac

# Build the CLASSPATH required to build the Java samples

CLASSPATH=$JAR_HOME/axis.jar
for jar in commons-discovery-0.2 commons-logging-1.1 log4j-1.2.8 jaxrpc saaj \
	wsdl4j-1.5.1; do
  CLASSPATH="$CLASSPATH:$JAR_HOME/$jar.jar"
done
#CLASSPATH="$CLASSPATH:../common_class"
CLASSPATH="$CLASSPATH:../.."

# Compile

$JAVAC -classpath "$CLASSPATH" *.java
