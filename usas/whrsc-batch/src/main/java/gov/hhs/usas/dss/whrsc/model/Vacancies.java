package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class Vacancies extends Report{
	
	@Value("${vac.search.path}") private String searchPath;
	@Value("${vac.intg.type}") private String intgType;
	@Value("${vac.file.name}") private String fileName;
	@Value("${vac.report.name}") private String reportName;
	@Value("${vac.truncate}") private String spTruncate;
	@Value("${vac.run.report}") private boolean runReport;

	public Vacancies() {
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
