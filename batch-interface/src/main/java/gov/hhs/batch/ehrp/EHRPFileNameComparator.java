package gov.hhs.batch.ehrp;

import java.io.File;
import java.util.Comparator;


/**
 * This class is a comparator class to sort the EHRP XML files in a specific order to process them.

 */
public class EHRPFileNameComparator implements Comparator
{
	/**
	 * Creates a new EHRPFileNameComparator object.
	 */
	public EHRPFileNameComparator()
	{
		super();
	}

	/**
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	public int compare(Object arg0, Object arg1)
	{
		File file1 = (File) arg0;
		File file2 = (File) arg1;
		String file1Name = file1.getName();
		String file2Name = file2.getName();
		long file1NameVal = getFileNameValue(file1Name);
		long file2NameVal = getFileNameValue(file2Name);

		if (file1NameVal > file2NameVal)
		{
			return 1;
		}
		else if (file1NameVal < file2NameVal)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}

	
	/**
	 *  Assumes the file Name to be of the following format 
	 *	HE_EWITS_RECRUIT_<SEQNO>.extension
	 *	example - HE_EWITS_RECRUIT_208200.xml
	 *	If the file name format changes , this has to change accordingly
	 *
	 * @param fileName the file Name
	 * 
	 * @return  a long value associated with the file name for comparison.
	 * 
	 */
	private long getFileNameValue(String fileName)
	{
		String nameWithoutExtn = fileName.substring(0, fileName.lastIndexOf("."));

		return Long.parseLong(nameWithoutExtn.substring(nameWithoutExtn.lastIndexOf('_') + 1, nameWithoutExtn.length()));
	}

}
