#!/bin/sh
#
# script to run encript command
#

#
# Collect the command line args
#
CMD_LINE_ARGS=$*

JS_CMD_NAME=$0
 

#
# Set command class
#
JS_ENC_CMD_CLASS=com.hs.frmwk.web.encoding.Cipher01
 
#
# Loop through and add all class jars
#
# Jars are in lib
#

EXP_CLASSPATH=../lib/hwweb.jar:../lib/rijndael-api.jar


#
# Locate the java binary bundled with installer
#
# If "../java/bin/java" exists, use it
#

JAVA_EXEC=java

if test -f ../java/bin/java
then
    JAVA_HOME=../java
    PATH=$JAVA_HOME/bin:$PATH
    JAVA_EXEC=$JAVA_HOME/bin/java
fi

# run java
$JAVA_EXEC -cp "$EXP_CLASSPATH" $JS_ENC_CMD_CLASS $JS_CMD_NAME $CMD_LINE_ARGS
