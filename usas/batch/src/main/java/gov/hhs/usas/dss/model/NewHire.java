package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class NewHire extends Report {
	
	@Value("${newHire.search.path}") private String searchPath;
	@Value("${newHire.intg.type}") private String intgType;
	@Value("${newHire.file.name}") private String fileName;
	@Value("${newHire.parm.num}") private int parmNum;
	@Value("${newHire.rvp.name}") private String rvpName;
	@Value("${newHire.rpt.iteration}") private int rptIteration; 
	@Value("${newHire.date.interval}") private int dateInterval;
	@Value("${newHire.end.date}") private String endDate;
	@Value("${newHire.truncate}") private String spTruncate;
	@Value("${newHire.run.report}") private boolean runReport;

	public NewHire() {

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