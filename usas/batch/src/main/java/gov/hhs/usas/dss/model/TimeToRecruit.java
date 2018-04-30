package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class TimeToRecruit extends Report {
	
	@Value("${recruit.search.path}") private String searchPath;
	@Value("${recruit.intg.type}") private String intgType;
	@Value("${recruit.file.name}") private String fileName;
	@Value("${recruit.parm.num}") private int parmNum;
	@Value("${recruit.rvp.name}") private String rvpName;
	@Value("${recruit.rpt.iteration}") private int rptIteration; 
	@Value("${recruit.date.increment}") private int dateIncrement;
	@Value("${recruit.end.date}") private String endDate;
	@Value("${recruit.truncate}") private String spTruncate;
	@Value("${recruit.run.report}") private boolean runReport;

	public TimeToRecruit() {

	}
	
	@PostConstruct
	public void construct() {
		super.setSearchPath(searchPath);
		super.setIntgType(intgType);
		super.setFileName(fileName);
		super.setParmNum(parmNum);
		super.setRvpName(rvpName);
		super.setRptIteration(rptIteration);
		super.setDateIncrement(dateIncrement);
		super.setEndDate(endDate);
		super.setSpTruncate(spTruncate);
		super.setRunReport(runReport);
	}
	
}
