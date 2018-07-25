package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class NewHireForms extends WHRSCDatastoreReport{
	
	@Value("${nhf.search.path}") private String searchPath;
	@Value("${nhf.intg.type}") private String intgType;
	@Value("${nhf.file.name}") private String fileName;
	@Value("${nhf.report.name}") private String reportName;
	@Value("${nhf.truncate}") private String spTruncate;
	@Value("${nhf.run.report}") private boolean runReport;

	public NewHireForms() {
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