package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class Task extends Report {
	
	@Value("${task.search.path}") private String searchPath;
	@Value("${task.intg.type}") private String intgType;
	@Value("${task.file.name}") private String fileName;
	@Value("${task.report.name}") private String reportName;
	@Value("${task.parm.num}") private int parmNum;
	@Value("${task.rvp.name}") private String rvpName;
	@Value("${task.rpt.iteration}") private int rptIteration; 
	@Value("${task.date.interval}") private int dateInterval;
	@Value("${task.end.date}") private String endDate;
	@Value("${task.truncate}") private String spTruncate;
	@Value("${task.run.report}") private boolean runReport;

	public Task() {

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
		super.setRunReport(runReport);
	}
	
}
