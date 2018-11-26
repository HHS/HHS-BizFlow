package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class CDCTimeToStaff extends Report {
	
	@Value("${cdc.staff.search.path}") private String searchPath;
	@Value("${cdc.staff.intg.type}") private String intgType;
	@Value("${cdc.staff.file.name}") private String fileName;
	@Value("${cdc.staff.report.name}") private String reportName;
	@Value("${cdc.staff.parm.num}") private int parmNum;
	@Value("${cdc.staff.rvp.name}") private String rvpName;
	@Value("${cdc.staff.rpt.iteration}") private int rptIteration; 
	@Value("${cdc.staff.date.interval}") private int dateInterval;
	@Value("${cdc.staff.end.date}") private String endDate;
	@Value("${cdc.staff.truncate}") private String spTruncate;
	@Value("${cdc.staff.stgToFnl}") private String spStgToFnl;
	@Value("${cdc.staff.run.report}") private boolean runReport;

	public CDCTimeToStaff() {

	}
	
	@PostConstruct
	public void construct() {
		super.setSearchPath(searchPath);
		super.setIntgType(intgType);
		super.setFileName(fileName);
		super.setReportName(reportName);
		super.setParmNum(parmNum);
		super.setRvpName(rvpName);
		super.setRptIteration(rptIteration);
		super.setDateInterval(dateInterval);
		super.setEndDate(endDate);
		super.setSpTruncate(spTruncate);
		super.setSpStgToFnl(spStgToFnl);
		super.setRunReport(runReport);
	}
	
}
