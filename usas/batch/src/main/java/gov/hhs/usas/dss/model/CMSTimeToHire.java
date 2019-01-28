package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class CMSTimeToHire extends Report {
	
	@Value("${cms.time2hire.search.path}") private String searchPath;
	@Value("${cms.time2hire.intg.type}") private String intgType;
	@Value("${cms.time2hire.file.name}") private String fileName;
	@Value("${cms.time2hire.report.name}") private String reportName;
	@Value("${cms.time2hire.parm.num}") private int parmNum;
	@Value("${cms.time2hire.rvp.name}") private String rvpName;
	@Value("${cms.time2hire.rpt.iteration}") private int rptIteration; 
	@Value("${cms.time2hire.date.interval}") private int dateInterval;
	@Value("${cms.time2hire.end.date}") private String endDate;
	@Value("${cms.time2hire.truncate}") private String spTruncate;
	@Value("${cms.time2hire.stgToFnl}") private String spStgToFnl;
	@Value("${cms.time2hire.run.report}") private boolean runReport;

	public CMSTimeToHire() {

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
