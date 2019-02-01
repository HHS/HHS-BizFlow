package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class CDCCertificate extends Report {
	
	@Value("${cdc.cert.search.path}") private String searchPath;
	@Value("${cdc.cert.intg.type}") private String intgType;
	@Value("${cdc.cert.file.name}") private String fileName;
	@Value("${cdc.cert.report.name}") private String reportName;
	@Value("${cdc.cert.parm.num}") private int parmNum;
	@Value("${cdc.cert.rvp.name}") private String rvpName;
	@Value("${cdc.cert.rpt.iteration}") private int rptIteration; 
	@Value("${cdc.cert.date.interval}") private int dateInterval;
	@Value("${cdc.cert.end.date}") private String endDate;
	@Value("${cdc.cert.truncate}") private String spTruncate;
	@Value("${cdc.cert.stgToFnl}") private String spStgToFnl;
	@Value("${cdc.cert.run.report}") private boolean runReport;

	public CDCCertificate() {

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
