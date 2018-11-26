package gov.hhs.usas.dss;

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
		
		Date startDate;
		Date endDate;

		DateFormat displayStartVal = new SimpleDateFormat("MMM dd,yyyy 12:00 'AM'"); //Jan 31, 2018 12:00 AM
		DateFormat useStartVal = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00.000"); //2018-01-31T00:00:00.000
		DateFormat displayEndVal = new SimpleDateFormat("MMM dd,yyyy 11:59 'PM'"); //Jan 31, 2018 12:00 AM
		DateFormat useEndVal = new SimpleDateFormat("yyyy-MM-dd'T'23:59:59.999"); //2018-01-31T00:00:00.000	
		
		Calendar cStart = Calendar.getInstance();
		cStart.setTime(currentDate);
		
		cStart.add(Calendar.DATE, -num);
		
		startDate = cStart.getTime();
		
		Calendar cEnd = Calendar.getInstance();
		cEnd.setTime(currentDate);
		
		cEnd.add(Calendar.DATE, -1);
		
		endDate = cEnd.getTime();
		
		setStartDisplayVal(displayStartVal.format(startDate));
		setStartUseVal(useStartVal.format(startDate));
		setEndDisplayVal(displayEndVal.format(endDate));
		setEndUseVal(useEndVal.format(endDate));
		
		return startDate;
		
	}

	
	public static void generateDateRange(Date currentDate, String dateCutOffStr) throws ParseException {
		
		Date endDateValue;
		Date dateCutoff;
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		DateFormat displayStartVal = new SimpleDateFormat("MMM dd,yyyy 12:00 'AM'"); //Jan 31, 2018 12:00 AM
		DateFormat useStartVal = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00.000"); //2018-01-31T00:00:00.000
		DateFormat displayEndVal = new SimpleDateFormat("MMM dd,yyyy 11:59 'PM'"); //Jan 31, 2018 12:00 AM
		DateFormat useEndVal = new SimpleDateFormat("yyyy-MM-dd'T'23:59:59.999"); //2018-01-31T00:00:00.000			
		
		dateCutoff =dateFormat.parse(dateCutOffStr);
		
		Calendar cEnd = Calendar.getInstance();
		cEnd.setTime(currentDate);
		
		cEnd.add(Calendar.DATE, -1);
		
		endDateValue = cEnd.getTime();
		
		
		setStartDisplayVal(displayStartVal.format(dateCutoff));
		setStartUseVal(useStartVal.format(dateCutoff));
		setEndDisplayVal(displayEndVal.format(endDateValue));
		setEndUseVal(useEndVal.format(endDateValue));
		
	}
	
	public static int generateDateIteration(Date currentDate, String endDateStr, int dateIncrement) throws ParseException {
		
		Date endDate;
		double dayDiff;
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		
		endDate =dateFormat.parse(endDateStr);
		
		dayDiff = ((currentDate.getTime()- endDate.getTime())/86400000);
		
		return (int) Math.ceil((dayDiff/Math.abs(-dateIncrement)));
		
	}
	
}