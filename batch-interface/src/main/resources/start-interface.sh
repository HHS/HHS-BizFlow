#!/bin/sh

#BASEDIR=$(dirname "$0")
BASEDIR=$(cd `dirname $0` && pwd)
echo using BASEDIR of $BASEDIR
cd $BASEDIR

/usr/bin/nohup ./run-jar.sh > /dev/null 2>&1 &