package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class CMSTimeOfPossession extends Report {
	
	@Value("${cms.possess.search.path}") private String searchPath;
	@Value("${cms.possess.intg.type}") private String intgType;
	@Value("${cms.possess.file.name}") private String fileName;
	@Value("${cms.possess.report.name}") private String reportName;
	@Value("${cms.possess.parm.num}") private int parmNum;
	@Value("${cms.possess.rvp.name}") private String rvpName;
	@Value("${cms.possess.rpt.iteration}") private int rptIteration; 
	@Value("${cms.possess.date.interval}") private int dateInterval;
	@Value("${cms.possess.end.date}") private String endDate;
	@Value("${cms.possess.truncate}") private String spTruncate;
	@Value("${cms.possess.stgToFnl}") private String spStgToFnl;
	@Value("${cms.possess.run.report}") private boolean runReport;
	

	public CMSTimeOfPossession() {

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
