package gov.hhs.usas.dss.whrsc.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class RequestRatingCombinations extends Report{
	
	@Value("${rrc.search.path}") private String searchPath;
	@Value("${rrc.intg.type}") private String intgType;
	@Value("${rrc.file.name}") private String fileName;
	@Value("${rrc.report.name}") private String reportName;
	@Value("${rrc.truncate}") private String spTruncate;
	@Value("${rrc.run.report}") private boolean runReport;

	public RequestRatingCombinations() {
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
