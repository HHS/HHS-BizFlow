#!/bin/sh
#
# Run the program at the command-line.
#

JAVA_HOME=/Library/Java/JavaVirtualMachines/jdk1.7.0_76.jdk/Contents/Home
JAR_HOME=.

# Build the CLASSPATH required
CLASSPATH=
#for dir in ../classess; do
#  CLASSPATH="$CLASSPATH:$dir"
#done
for jar in ojdbc6 sqljdbc4 jdbcconn ; do
  CLASSPATH="$CLASSPATH:$JAR_HOME/$jar.jar"
done

# Run program
$JAVA_HOME/bin/java -classpath $CLASSPATH JDBCConn $1 $2 $3 $4 $5 $6
