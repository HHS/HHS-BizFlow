package gov.hhs.batch.ehrp;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class EHRPFileUtil {

	
	/**
	 * Function to return the sorted list of fileNames
	 * @param fileList Unordered list of filenames
	 * @return Returns ordered list of filenames
	 */
	public ArrayList getOrderedFileList(ArrayList fileList)
	{
		Collections.sort(fileList, new EHRPFileNameComparator());

		return fileList;
	}
	
	/**
	 * Function to check if a directory exists, if
	 * not a directory will be created
	 * @param inbound directory
	 * @param processing directory
	 * @param archive directory
	 * @param error directory
	 */
	public static void checkInterfaceDirectories(File inboundDirectory,
										   File processingDirectory,
										   File archiveDirectory,
										   File errorDirectory) throws Exception {
		//Creates inbound directory
		if(!inboundDirectory.exists()) {
			if(false == inboundDirectory.mkdir()) {
				throw new Exception("Could not create inbound directory"); 
			}
		}
		//Creates processing directory
		if(!processingDirectory.exists()) {
			if(false == processingDirectory.mkdir()) {
				throw new Exception("Could not create processing directory"); 
			}
		}
		//Creates archive directory
		if(!archiveDirectory.exists()) {
			if(false == archiveDirectory.mkdir()) {
				throw new Exception("Could not create archive directory"); 
			}
		}
		//Creates error directory
		if(!errorDirectory.exists()) {
			if(false == errorDirectory.mkdir()) {
				throw new Exception("Could not create error directory"); 
			}
		}
	}
	
	/**
	 * Function to return if a string is null
	 * @param s String
	 * @return Returns boolean
	 */	
	public static boolean isNull(String s) {
		return(s==null || s.trim().equals(""));
	}
	
	
	/**
	 * Function to execute shell script
	 * @param scriptName - Name of the shell script to be executed
	 * @param scriptPath - Location of the script
	 * @throws IOException 
	 */	
	public void executeShellScript(String scriptName, String scriptPath) throws IOException {

		String[] cmdScript = {scriptPath + "/" + scriptName};
		Process procScript = Runtime.getRuntime().exec(cmdScript);
	}
}
