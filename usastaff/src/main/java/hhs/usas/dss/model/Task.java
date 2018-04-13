package hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class Task extends Report {
	
	@Value("${task.search.path}") private String searchPath;
	@Value("${task.intg.type}") private String intgType;
	@Value("${task.file.name}") private String fileName;
	@Value("${task.parm.num}") private int parmNum;
	@Value("${task.rvp.name}") private String rvpName;
	@Value("${task.rpt.iteration}") private int rptIteration; 
	@Value("${task.date.increment}") private int dateIncrement;
	@Value("${task.end.date}") private String endDate;
	@Value("${task.truncate}") private String spTruncate;
	@Value("${task.run.report}") private boolean runReport;

	public Task() {

	}
	
	@PostConstruct
	public void construct() {
		super.setSearchPath(searchPath);
		super.setIntgType(intgType);
		super.setFileName(fileName);
		super.setParmNum(parmNum);
		super.setRvpName(rvpName);
		super.setRptIteration(rptIteration);
		super.setDateIncrement(dateIncrement);
		super.setEndDate(endDate);
		super.setSpTruncate(spTruncate);
		super.setRunReport(runReport);
	}
	
}
