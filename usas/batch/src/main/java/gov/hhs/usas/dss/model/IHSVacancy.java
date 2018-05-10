package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class IHSVacancy extends Report {
	
	@Value("${ihs.vac.search.path}") private String searchPath;
	@Value("${ihs.vac.intg.type}") private String intgType;
	@Value("${ihs.vac.file.name}") private String fileName;
	@Value("${ihs.vac.parm.num}") private int parmNum;
	@Value("${ihs.vac.rvp.name}") private String rvpName;
	@Value("${ihs.vac.rpt.iteration}") private int rptIteration; 
	@Value("${ihs.vac.date.interval}") private int dateInterval;
	@Value("${ihs.vac.end.date}") private String endDate;
	@Value("${ihs.vac.truncate}") private String spTruncate;
	@Value("${ihs.vac.run.report}") private boolean runReport;

	public IHSVacancy() {

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