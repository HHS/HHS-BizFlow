package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class RequestVacancyCombinations extends Report{
	
	@Value("${rvc.search.path}") private String searchPath;
	@Value("${rvc.intg.type}") private String intgType;
	@Value("${rvc.file.name}") private String fileName;
	@Value("${rvc.report.name}") private String reportName;
	@Value("${rvc.truncate}") private String spTruncate;
	@Value("${rvc.run.report}") private boolean runReport;

	public RequestVacancyCombinations() {
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
