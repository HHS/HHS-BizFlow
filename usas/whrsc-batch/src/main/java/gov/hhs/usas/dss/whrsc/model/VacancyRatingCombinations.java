package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class VacancyRatingCombinations extends Report{
	
	@Value("${vrc.search.path}") private String searchPath;
	@Value("${vrc.intg.type}") private String intgType;
	@Value("${vrc.file.name}") private String fileName;
	@Value("${vrc.report.name}") private String reportName;
	@Value("${vrc.truncate}") private String spTruncate;
	@Value("${vrc.run.report}") private boolean runReport;

	public VacancyRatingCombinations() {
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
