package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class NewHires extends WHRSCDatastoreReport{
	
	@Value("${nh.search.path}") private String searchPath;
	@Value("${nh.intg.type}") private String intgType;
	@Value("${nh.file.name}") private String fileName;
	@Value("${nh.report.name}") private String reportName;
	@Value("${nh.truncate}") private String spTruncate;
	@Value("${nh.run.report}") private boolean runReport;

	public NewHires() {
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