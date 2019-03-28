package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class CMSRequests extends Report {
	
	@Value("${cms.reqst.search.path}") private String searchPath;
	@Value("${cms.reqst.intg.type}") private String intgType;
	@Value("${cms.reqst.file.name}") private String fileName;
	@Value("${cms.reqst.report.name}") private String reportName;
	@Value("${cms.reqst.parm.num}") private int parmNum;
	@Value("${cms.reqst.rvp.name}") private String rvpName;
	@Value("${cms.reqst.rpt.iteration}") private int rptIteration; 
	@Value("${cms.reqst.date.interval}") private int dateInterval;
	@Value("${cms.reqst.end.date}") private String endDate;
	@Value("${cms.reqst.truncate}") private String spTruncate;
	@Value("${cms.reqst.stgToFnl}") private String spStgToFnl;
	@Value("${cms.reqst.run.report}") private boolean runReport;

	public CMSRequests() {

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
