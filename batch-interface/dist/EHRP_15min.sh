#!/bin/bash
###########################################################
#Pulls EHRP data from MARS Drop Box to BizFlow local server
############################################################

REMOTE_FOLDER=<Insert MARs folder that contains the EHRP files> 
MARS=<Insert MARS sftp connection string>
LOG_HOME=<Insert directory that contains log files>
EHRP_FILES=<Insert directory that contains inbound files>
EHRP_ARCH=<Insert directory that contains archive files>
EHRP_ERROR=<Insert directory that contains error files>
NOW=$(date +"%m-%d-%y-%H-%M-%S-%p")
CURRDATE=`date`
LOGFILE=$LOG_HOME/getEHRPFiles_$NOW
echo "Started script at $CURRDATE" >> $LOGFILE
echo $CURRDATE > $LOG_HOME/lastRetrieval

#Connect to MARS Drop Box to Fetch Files
cd $EHRP_FILES
sftp $MARS <<EOF
        lcd $EHRP_FILES
        cd $REMOTE_FOLDER
        mget *.xml
        rm *.xml
        quit
EOF
if [ $? -ne 0 ]; then
        echo "EHRP file transfer failed from MARS Drop Box to Ewits Server" >> $LOGFILE
else
        echo "EHRP file transfer successful between MARS Drop Box and Ewits Server" >> $LOGFILE
fi


#Change permissions to read/write for inbound files
if [ -z "$(ls -A $EHRP_FILES)" ]; then
        echo "There are no files in the inbound directory" >> $LOGFILE
else
        cd $EHRP_FILES
        chmod 644 *.xml
        echo "Changed permissions for inbound files" >> $LOGFILE
fi

#Removes Log Files Older than 180 Days
cd $LOG_HOME
if [ $? -ne 0 ]; then
        echo "Error in removing Log Files Older than 180 Days" >> $LOGFILE
else
        find . \( ! -name . -prune \) -type f -prune -mtime +180 -exec rm {} \;
        echo "Removed log files older than 180 days" >> $LOGFILE
fi

#Removes Archive Files Older than 180 Days
cd $EHRP_ARCH
if [ $? -ne 0 ]; then
        echo "Error in removing Archive Files Older than 180 Days" >> $LOGFILE
else
        find . \( ! -name . -prune \) -type f -prune -mtime +180 -exec rm {} \;
        echo "Removed archive files older than 180 days" >> $LOGFILE
fi

#Removes Error Files Older than 180 Days
cd $EHRP_ERROR
if [ $? -ne 0 ]; then
        echo "Error in removing Error Files Older than 180 Days" >> $LOGFILE
else
        find . \( ! -name . -prune \) -type f -prune -mtime +180 -exec rm {} \;
        echo "Removed error files older than 180 days" >> $LOGFILE
fi