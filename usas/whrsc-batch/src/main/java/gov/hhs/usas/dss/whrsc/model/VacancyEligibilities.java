package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class VacancyEligibilities extends Report{
	
	@Value("${ve.search.path}") private String searchPath;
	@Value("${ve.intg.type}") private String intgType;
	@Value("${ve.file.name}") private String fileName;
	@Value("${ve.report.name}") private String reportName;
	@Value("${ve.truncate}") private String spTruncate;
	@Value("${ve.run.report}") private boolean runReport;

	public VacancyEligibilities() {
	}
	
	@PostConstruct
	public void construct() {
		super.setSearchPath(searchPath);
		super.setIntgType(intgType);
		super.setFileName(fileName);
		super.setReportName(reportName);		
		super.setSpTruncate(spTruncate);
		super.setRunReport(runReport);
	}
}
