package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class PermissionProfiles extends WHRSCDatastoreReport{
	
	@Value("${pp.search.path}") private String searchPath;
	@Value("${pp.intg.type}") private String intgType;
	@Value("${pp.file.name}") private String fileName;
	@Value("${pp.report.name}") private String reportName;
	@Value("${pp.truncate}") private String spTruncate;
	@Value("${pp.run.report}") private boolean runReport;

	public PermissionProfiles() {
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
