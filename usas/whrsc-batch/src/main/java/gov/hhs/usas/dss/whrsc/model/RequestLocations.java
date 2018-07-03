package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class RequestLocations extends Report{
	
	@Value("${rl.search.path}") private String searchPath;
	@Value("${rl.intg.type}") private String intgType;
	@Value("${rl.file.name}") private String fileName;
	@Value("${rl.report.name}") private String reportName;
	@Value("${rl.truncate}") private String spTruncate;
	@Value("${rl.run.report}") private boolean runReport;

	public RequestLocations() {
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
