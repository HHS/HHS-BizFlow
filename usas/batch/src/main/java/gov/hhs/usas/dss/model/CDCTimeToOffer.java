package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class CDCTimeToOffer extends Report {
	
	@Value("${cdc.offer.search.path}") private String searchPath;
	@Value("${cdc.offer.intg.type}") private String intgType;
	@Value("${cdc.offer.file.name}") private String fileName;
	@Value("${cdc.offer.report.name}") private String reportName;
	@Value("${cdc.offer.parm.num}") private int parmNum;
	@Value("${cdc.offer.rvp.name}") private String rvpName;
	@Value("${cdc.offer.rpt.iteration}") private int rptIteration; 
	@Value("${cdc.offer.date.interval}") private int dateInterval;
	@Value("${cdc.offer.end.date}") private String endDate;
	@Value("${cdc.offer.truncate}") private String spTruncate;
	@Value("${cdc.offer.stgToFnl}") private String spStgToFnl;
	@Value("${cdc.offer.run.report}") private boolean runReport;

	public CDCTimeToOffer() {

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
