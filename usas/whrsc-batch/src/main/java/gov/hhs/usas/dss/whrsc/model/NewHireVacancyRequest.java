package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class NewHireVacancyRequest extends WHRSCDatastoreReport{
	
	@Value("${nhvr.search.path}") private String searchPath;
	@Value("${nhvr.intg.type}") private String intgType;
	@Value("${nhvr.file.name}") private String fileName;
	@Value("${nhvr.report.name}") private String reportName;
	@Value("${nhvr.truncate}") private String spTruncate;
	@Value("${nhvr.run.report}") private boolean runReport;

	public NewHireVacancyRequest() {
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