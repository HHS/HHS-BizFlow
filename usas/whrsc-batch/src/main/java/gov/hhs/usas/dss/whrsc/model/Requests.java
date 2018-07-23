package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class Requests extends WHRSCDatastoreReport{
	
	@Value("${req.search.path}") private String searchPath;
	@Value("${req.intg.type}") private String intgType;
	@Value("${req.file.name}") private String fileName;
	@Value("${req.report.name}") private String reportName;
	@Value("${req.truncate}") private String spTruncate;
	@Value("${req.run.report}") private boolean runReport;

	public Requests() {
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
