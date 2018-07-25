package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class CertificateLocations  extends WHRSCDatastoreReport{
	
	@Value("${cl.search.path}") private String searchPath;
	@Value("${cl.intg.type}") private String intgType;
	@Value("${cl.file.name}") private String fileName;
	@Value("${cl.report.name}") private String reportName;
	@Value("${cl.truncate}") private String spTruncate;
	@Value("${cl.run.report}") private boolean runReport;

	public CertificateLocations() {
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
