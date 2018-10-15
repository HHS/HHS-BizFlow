#!/bin/sh
#

#BASEDIR=$(dirname "$0")
BASEDIR=$(cd `dirname $0` && pwd)
echo using BASEDIR of $BASEDIR
cd $BASEDIR

# REMOVE this when you edit this file.
echo ============================
echo WARNING: You MUST edit this file before you can run this application.
echo ============================

#-----------------------------------------------------------
# CHANGE the following environment variables to point to
# the Java Development Kit and dependency library location.
#-----------------------------------------------------------
#JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_76.jdk/Contents/Home
JAVA_HOME=/usr/lib/jvm/jre-1.7.0-openjdk.x86_64
LIB_DIR=$BASEDIR/lib
CONF_DIR=$BASEDIR/conf
EXECJAR=$BASEDIR/interface-0.0.1-SNAPSHOT.jar

#-----------------------------
# Build the CLASSPATH required
#-----------------------------
CLASSPATH=$CLASSPATH:.:$BASEDIR:$LIB_DIR/*:$CONF_DIR:$EXECJAR
#for dir in ../common_class; do
#  CLASSPATH="$CLASSPATH:$dir"
#done

#debug - show classpath
#echo JAVA_HOME = $JAVA_HOME
#echo CLASSPATH = $CLASSPATH

#-----------------------------
# Run application
#-----------------------------
$JAVA_HOME/bin/java -jar $EXECJAR $1 $2 $3 $4 $5 & echo $! > $BASEDIR/interface.pid
#$JAVA_HOME/bin/java -classpath $CLASSPATH org.springframework.boot.loader.JarLauncher  $1 $2 $3 $4 $5
