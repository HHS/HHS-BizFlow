package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class NewHireOnboardingDocuments extends Report{
	
	@Value("${nhod.search.path}") private String searchPath;
	@Value("${nhod.intg.type}") private String intgType;
	@Value("${nhod.file.name}") private String fileName;
	@Value("${nhod.report.name}") private String reportName;
	@Value("${nhod.truncate}") private String spTruncate;
	@Value("${nhod.run.report}") private boolean runReport;

	public NewHireOnboardingDocuments() {
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