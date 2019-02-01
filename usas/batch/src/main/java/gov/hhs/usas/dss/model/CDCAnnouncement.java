package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class CDCAnnouncement extends Report {
	
	@Value("${cdc.ann.search.path}") private String searchPath;
	@Value("${cdc.ann.intg.type}") private String intgType;
	@Value("${cdc.ann.file.name}") private String fileName;
	@Value("${cdc.ann.report.name}") private String reportName;
	@Value("${cdc.ann.parm.num}") private int parmNum;
	@Value("${cdc.ann.rvp.name}") private String rvpName;
	@Value("${cdc.ann.rpt.iteration}") private int rptIteration; 
	@Value("${cdc.ann.date.interval}") private int dateInterval;
	@Value("${cdc.ann.end.date}") private String endDate;
	@Value("${cdc.ann.truncate}") private String spTruncate;
	@Value("${cdc.ann.stgToFnl}") private String spStgToFnl;
	@Value("${cdc.ann.run.report}") private boolean runReport;

	public CDCAnnouncement() {

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
