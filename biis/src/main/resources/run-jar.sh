#!/bin/sh
#

BASEDIR=$(dirname "$0")
echo using BASEDIR of $BASEDIR

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
CLASSPATH=$CLASSPATH:.:$BASEDIR:$LIB_DIR/*:$CONF_DIR:$EXECJAR
#for dir in ../common_class; do
#  CLASSPATH="$CLASSPATH:$dir"
#done

#debug - show classpath
#echo $CLASSPATH

#-----------------------------
# Run application
#-----------------------------
cd $BASEDIR
$JAVA_HOME/bin/java -jar $EXECJAR $1 $2 $3 $4 $5
#$JAVA_HOME/bin/java -classpath $CLASSPATH org.springframework.boot.loader.JarLauncher  $1 $2 $3 $4 $5
