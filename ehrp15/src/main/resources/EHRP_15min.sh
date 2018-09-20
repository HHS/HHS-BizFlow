#!/bin/bash
###########################################################
#Pulls EHRP data from MARS Drop Box to BizFlow local server
############################################################

SCRIPT_HOME=<INSERT directory path for location of getEHRPFiles_sftp.txt>
LOG_HOME=<INSERT directory path for log files>
EHRP_FILES=<INSERT directory path for inbound files>
EHRP_ARCH=<Insert directory path for archived files>
EHRP_ERROR=<Insert directory path for error files>
NOW=$(date +"%m-%d-%y-%H-%M-%S-%p")
CURRDATE=`date`
LOGFILE=$LOG_HOME/getEHRPFiles_$NOW
echo "Started script at $CURRDATE" >> $LOGFILE
echo $CURRDATE > $LOG_HOME/lastRetrieval

#Connect to MARS Drop Box to Fetch Files
sftp -b $SCRIPT_HOME/getEHRPFiles_sftp.txt <INSERT SFTP CONNECTION STRING FOR MARS DROP BOX>
if [ $? -ne 0 ]; then
	echo "EHRP file transfer failed from MARS Drop Box to Ewits Server" >> $LOGFILE
else
	echo "EHRP file transfer successful between MARS Drop Box and Ewits Server" >> $LOGFILE
fi

#Change permissions to read/write for inbound files
if cd $EHRP_FILE; then
	find -type f -exec chmod 644 *.xml {} \;
else
	echo "Error in changing permissions for inbound files" >> $LOGFILE
fi

#Removes Log Files Older than 180 Days
if cd $LOG_HOME; then
	find . \( ! -name . -prune \) -type f -prune -mtime +180 -exec rm {} \;
else
	echo "Error in removing Log Files Older than 180 Days" >> $LOGFILE
fi

#Removes Archive Files Older than 180 Days
if cd $EHRP_ARCH; then
	find . \( ! -name . -prune \) -type f -prune -mtime +180 -exec rm {} \;
else
	echo "Error in removing Archive Files Older than 180 Days" >> $LOGFILE
fi

#Removes Error Files Older than 180 Days
if cd $EHRP_ERROR; then
	find . \( ! -name . -prune \) -type f -prune -mtime +180 -exec rm {} \;
else
	echo "Error in removing Error Files Older than 180 Days" >> $LOGFILE
fi

echo "Finished script at `date`" >> $LOGFILE