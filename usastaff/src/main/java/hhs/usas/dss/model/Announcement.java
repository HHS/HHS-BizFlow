package hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class Announcement extends Report {
	
	@Value("${ann.search.path}") private String searchPath;
	@Value("${ann.intg.type}") private String intgType;
	@Value("${ann.file.name}") private String fileName;
	@Value("${ann.parm.num}") private int parmNum;
	@Value("${ann.svp.name}") private String svpName;
	@Value("${ann.svp.useval}") private String svpUseval;
	@Value("${ann.svp.display}") private String svpDisplay;
	@Value("${ann.rvp.name}") private String rvpName;
	@Value("${ann.rpt.iteration}") private int rptIteration; 
	@Value("${ann.date.increment}") private int dateIncrement;
	@Value("${ann.end.date}") private String endDate;
	@Value("${ann.truncate}") private String spTruncate;
	@Value("${ann.run.report}") private boolean runReport;

	public Announcement() {

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
		super.setDateIncrement(dateIncrement);
		super.setEndDate(endDate);
		super.setSpTruncate(spTruncate);
		super.setRunReport(runReport);
	}
	
}
