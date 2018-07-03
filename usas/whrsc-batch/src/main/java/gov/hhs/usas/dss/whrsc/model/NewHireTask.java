package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class NewHireTask extends Report{
	
	@Value("${nht.search.path}") private String searchPath;
	@Value("${nht.intg.type}") private String intgType;
	@Value("${nht.file.name}") private String fileName;
	@Value("${nht.report.name}") private String reportName;
	@Value("${nht.truncate}") private String spTruncate;
	@Value("${nht.run.report}") private boolean runReport;

	public NewHireTask() {
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