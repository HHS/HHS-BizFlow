#!/bin/sh

cd ~/Desktop/locator/build
ant
if [ $? -ne 0 ]
then
    echo "error happend"
fi