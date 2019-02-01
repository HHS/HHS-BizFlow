package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class CDCAudit extends Report {
	
	@Value("${cdc.audit.search.path}") private String searchPath;
	@Value("${cdc.audit.intg.type}") private String intgType;
	@Value("${cdc.audit.file.name}") private String fileName;
	@Value("${cdc.audit.report.name}") private String reportName;
	@Value("${cdc.audit.parm.num}") private int parmNum;
	@Value("${cdc.audit.rvp.name}") private String rvpName;
	@Value("${cdc.audit.rpt.iteration}") private int rptIteration; 
	@Value("${cdc.audit.date.interval}") private int dateInterval;
	@Value("${cdc.audit.end.date}") private String endDate;
	@Value("${cdc.audit.truncate}") private String spTruncate;
	@Value("${cdc.audit.stgToFnl}") private String spStgToFnl;
	@Value("${cdc.audit.run.report}") private boolean runReport;

	public CDCAudit() {

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
