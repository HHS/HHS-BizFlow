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
	@Value("${rvw.parm.num}") private int parmNum;
	@Value("${rvw.rvp.name}") private String rvpName;
	@Value("${rvw.rpt.iteration}") private int rptIteration; 
	@Value("${rvw.date.increment}") private int dateIncrement;
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
		super.setParmNum(parmNum);
		super.setRvpName(rvpName);
		super.setRptIteration(rptIteration);
		super.setDateIncrement(dateIncrement);
		super.setEndDate(endDate);
		super.setSpTruncate(spTruncate);
		super.setRunReport(runReport);
	}

}
