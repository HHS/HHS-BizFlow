#!/bin/sh
#

#BASEDIR=$(dirname "$0")
BASEDIR=$(cd `dirname $0`/.. && pwd)
echo using BASEDIR of $BASEDIR
cd $BASEDIR/bin

# Remove or comment out this when you edit this file.
echo ============================
echo WARNING: You MUST edit this file before you can run this application.
echo ============================

#-----------------------------------------------------------
# CHANGE the following environment variables to point to
# the Java Development Kit and dependency library location.
#-----------------------------------------------------------
JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_76.jdk/Contents/Home
LIB_DIR=$BASEDIR/lib
CONF_DIR=$BASEDIR/conf
EXECJAR=$BASEDIR/biis-0.0.1-SNAPSHOT.jar

#-----------------------------
# Build the CLASSPATH required
#-----------------------------
CLASSPATH=$CLASSPATH:.:$BASEDIR/bin:$LIB_DIR/*:$CONF_DIR
#for dir in ../common_class; do
#  CLASSPATH="$CLASSPATH:$dir"
#done

#debug - show classpath
#echo $CLASSPATH

#-----------------------------
# Run application
#-----------------------------
#$JAVA_HOME/bin/java -jar $EXECJAR $1 $2 $3 $4 $5
$JAVA_HOME/bin/java -classpath $CLASSPATH gov.hhs.biis.BIISInterfaceApplication  $1 $2 $3 $4 $5
