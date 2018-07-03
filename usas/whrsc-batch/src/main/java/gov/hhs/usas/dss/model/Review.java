package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class Review extends Report {
	
	@Value("${rvw.search.path}") private String searchPath;
	@Value("${rvw.intg.type}") private String intgType;
	@Value("${rvw.file.name}") private String fileName;
	@Value("${rvw.report.name}") private String reportName;
	@Value("${rvw.parm.num}") private int parmNum;
	@Value("${rvw.rvp.name}") private String rvpName;
	@Value("${rvw.rpt.iteration}") private int rptIteration; 
	@Value("${rvw.date.interval}") private int dateInterval;
	@Value("${rvw.end.date}") private String endDate;
	@Value("${rvw.truncate}") private String spTruncate;
	@Value("${rvw.run.report}") private boolean runReport;

	public Review() {

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
