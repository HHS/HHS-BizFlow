package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class Request extends Report {
	
	@Value("${rqst.search.path}") private String searchPath;
	@Value("${rqst.intg.type}") private String intgType;
	@Value("${rqst.file.name}") private String fileName;
	@Value("${rqst.parm.num}") private int parmNum;
	@Value("${rqst.rvp.name}") private String rvpName;
	@Value("${rqst.rpt.iteration}") private int rptIteration; 
	@Value("${rqst.date.interval}") private int dateInterval;
	@Value("${rqst.end.date}") private String endDate;
	@Value("${rqst.truncate}") private String spTruncate;
	@Value("${rqst.run.report}") private boolean runReport;

	public Request() {

	}
	
	@PostConstruct
	public void construct() {
		super.setSearchPath(searchPath);
		super.setIntgType(intgType);
		super.setFileName(fileName);
		super.setParmNum(parmNum);
		super.setRvpName(rvpName);
		super.setRptIteration(rptIteration);
		super.setDateInterval(dateInterval);
		super.setEndDate(endDate);
		super.setSpTruncate(spTruncate);
		super.setRunReport(runReport);
	}

}