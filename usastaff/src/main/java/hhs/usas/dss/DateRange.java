package hhs.usas.dss;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateRange {
	
	private static String startDisplayVal;
	private static String startUseVal;
	private static String endDisplayVal;
	private static String endUseVal;
	
	public static String getStartDisplayVal() {
		return startDisplayVal;
	}

	public static void setStartDisplayVal(String startDisplayVal) {
		DateRange.startDisplayVal = startDisplayVal;
	}

	public static String getStartUseVal() {
		return startUseVal;
	}

	public static void setStartUseVal(String startUseVal) {
		DateRange.startUseVal = startUseVal;
	}

	public static String getEndDisplayVal() {
		return endDisplayVal;
	}

	public static void setEndDisplayVal(String endDisplayVal) {
		DateRange.endDisplayVal = endDisplayVal;
	}

	public static String getEndUseVal() {
		return endUseVal;
	}

	public static void setEndUseVal(String endUseVal) {
		DateRange.endUseVal = endUseVal;
	}

	public DateRange() {
		super();
	}

	public static Date generateDateRange(Date firstDate, int num) {
		
		Date currentDate = firstDate;
		Date pastDate;

		DateFormat displayVal = new SimpleDateFormat("MMM dd,yyyy 12:00 'AM'"); //Jan 31, 2018 12:00 AM
		DateFormat useVal = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00.000"); //2018-01-31T00:00:00.000			
		
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		
		c.add(Calendar.DATE, num);
		
		pastDate = c.getTime();
		
		setStartDisplayVal(displayVal.format(pastDate));
		setStartUseVal(useVal.format(pastDate));
		setEndDisplayVal(displayVal.format(currentDate));
		setEndUseVal(useVal.format(currentDate));
		
		return pastDate;
		
	}
	
}
