package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class Certificate extends Report {
	
	@Value("${cert.search.path}") private String searchPath;
	@Value("${cert.intg.type}") private String intgType;
	@Value("${cert.file.name}") private String fileName;
	@Value("${cert.parm.num}") private int parmNum;
	@Value("${cert.svp.name}") private String svpName;
	@Value("${cert.svp.useval}") private String svpUseval;
	@Value("${cert.svp.display}") private String svpDisplay;
	@Value("${cert.rvp.name}") private String rvpName;
	@Value("${cert.rpt.iteration}") private int rptIteration; 
	@Value("${cert.date.interval}") private int dateInterval;
	@Value("${cert.end.date}") private String endDate;
	@Value("${cert.truncate}") private String spTruncate;
	@Value("${cert.run.report}") private boolean runReport;

	public Certificate() {

	}
	
	@PostConstruct
	public void construct() {
		super.setSearchPath(searchPath);
		super.setIntgType(intgType);
		super.setFileName(fileName);
		super.setParmNum(parmNum);
		super.setSvpName(svpName);
		super.setSvpUseval(svpUseval);
		super.setSvpDisplay(svpDisplay);
		super.setRvpName(rvpName);
		super.setRptIteration(rptIteration);
		super.setDateInterval(dateInterval);
		super.setEndDate(endDate);
		super.setSpTruncate(spTruncate);
		super.setRunReport(runReport);
	}	
	
}
