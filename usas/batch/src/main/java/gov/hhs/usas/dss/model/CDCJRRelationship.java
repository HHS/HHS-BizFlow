package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class CDCJRRelationship extends Report {
	
	@Value("${cdc.jr.search.path}") private String searchPath;
	@Value("${cdc.jr.intg.type}") private String intgType;
	@Value("${cdc.jr.file.name}") private String fileName;
	@Value("${cdc.jr.report.name}") private String reportName;
	@Value("${cdc.jr.parm.num}") private int parmNum;
	@Value("${cdc.jr.rvp.name}") private String rvpName;
	@Value("${cdc.jr.rpt.iteration}") private int rptIteration; 
	@Value("${cdc.jr.date.interval}") private int dateInterval;
	@Value("${cdc.jr.end.date}") private String endDate;
	@Value("${cdc.jr.truncate}") private String spTruncate;
	@Value("${cdc.jr.stgToFnl}") private String spStgToFnl;
	@Value("${cdc.jr.run.report}") private boolean runReport;

	public CDCJRRelationship() {

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
