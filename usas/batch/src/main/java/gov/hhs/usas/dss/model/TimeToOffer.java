package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class TimeToOffer extends Report {
	
	@Value("${offer.search.path}") private String searchPath;
	@Value("${offer.intg.type}") private String intgType;
	@Value("${offer.file.name}") private String fileName;
	@Value("${offer.report.name}") private String reportName;
	@Value("${offer.parm.num}") private int parmNum;
	@Value("${offer.rvp.name}") private String rvpName;
	@Value("${offer.rpt.iteration}") private int rptIteration; 
	@Value("${offer.date.interval}") private int dateInterval;
	@Value("${offer.end.date}") private String endDate;
	@Value("${offer.truncate}") private String spTruncate;
	@Value("${offer.stgToFnl}") private String spStgToFnl;
	@Value("${offer.run.report}") private boolean runReport;

	public TimeToOffer() {

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
