package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class VacancyLocations extends WHRSCDatastoreReport{
	
	@Value("${vl.search.path}") private String searchPath;
	@Value("${vl.intg.type}") private String intgType;
	@Value("${vl.file.name}") private String fileName;
	@Value("${vl.report.name}") private String reportName;
	@Value("${vl.truncate}") private String spTruncate;
	@Value("${vl.run.report}") private boolean runReport;

	public VacancyLocations() {
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
