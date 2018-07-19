package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class VacancyMissionCriticalOccupations extends WHRSCDatastoreReport{
	
	@Value("${vmco.search.path}") private String searchPath;
	@Value("${vmco.intg.type}") private String intgType;
	@Value("${vmco.file.name}") private String fileName;
	@Value("${vmco.report.name}") private String reportName;
	@Value("${vmco.truncate}") private String spTruncate;
	@Value("${vmco.run.report}") private boolean runReport;

	public VacancyMissionCriticalOccupations() {
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
