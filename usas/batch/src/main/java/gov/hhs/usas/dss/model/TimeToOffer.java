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
	@Value("${offer.parm.num}") private int parmNum;
	@Value("${offer.rvp.name}") private String rvpName;
	@Value("${offer.rpt.iteration}") private int rptIteration; 
	@Value("${offer.date.increment}") private int dateIncrement;
	@Value("${offer.end.date}") private String endDate;
	@Value("${offer.truncate}") private String spTruncate;
	@Value("${offer.run.report}") private boolean runReport;

	public TimeToOffer() {

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
