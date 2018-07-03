package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class ApplicantNotifications extends Report{
	
	@Value("${an.search.path}") private String searchPath;
	@Value("${an.intg.type}") private String intgType;
	@Value("${an.file.name}") private String fileName;
	@Value("${an.report.name}") private String reportName;

	@Value("${an.truncate}") private String spTruncate;
	@Value("${an.run.report}") private boolean runReport;

	public ApplicantNotifications() {

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
