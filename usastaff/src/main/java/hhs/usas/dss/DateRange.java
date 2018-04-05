package hhs.usas.dss;

import java.text.DateFormat;
import java.text.ParseException;
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

	public static Date generateDateRange(Date currentDate, int num) {
		
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
	
	public static void generateDateRange(Date currentDate, String endDateStr) throws ParseException {
		
		Date endDate;
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		DateFormat displayVal = new SimpleDateFormat("MMM dd,yyyy 12:00 'AM'"); //i.e Jan 31, 2018 12:00 AM
		DateFormat useVal = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00.000"); //i.e 2018-01-31T00:00:00.000			
		
		endDate =dateFormat.parse(endDateStr);
		
		setStartDisplayVal(displayVal.format(endDate));
		setStartUseVal(useVal.format(endDate));
		setEndDisplayVal(displayVal.format(currentDate));
		setEndUseVal(useVal.format(currentDate));
		
	}
	
	public static int generateDateIteration(Date currentDate, String endDateStr, int dateIncrement) throws ParseException {
		
		Date endDate;
		double dayDiff;
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		endDate =dateFormat.parse(endDateStr);
		
		dayDiff = ((currentDate.getTime()- endDate.getTime())/86400000);
		
		return (int) Math.ceil((dayDiff/Math.abs(dateIncrement)));
		
	}
	
}
