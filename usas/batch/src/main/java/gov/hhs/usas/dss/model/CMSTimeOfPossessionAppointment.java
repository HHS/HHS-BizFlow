package gov.hhs.usas.dss.model;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class CMSTimeOfPossessionAppointment extends Report {
	
	@Value("${cms.possessApptmnt.search.path}") private String searchPath;
	@Value("${cms.possessApptmnt.intg.type}") private String intgType;
	@Value("${cms.possessApptmnt.file.name}") private String fileName;
	@Value("${cms.possessApptmnt.report.name}") private String reportName;
	@Value("${cms.possessApptmnt.parm.num}") private int parmNum;
	@Value("${cms.possessApptmnt.rvp.name}") private String rvpName;
	@Value("${cms.possessApptmnt.rpt.iteration}") private int rptIteration; 
	@Value("${cms.possessApptmnt.date.interval}") private int dateInterval;
	@Value("${cms.possessApptmnt.end.date}") private String endDate;
	@Value("${cms.possessApptmnt.truncate}") private String spTruncate;
	@Value("${cms.possessApptmnt.stgToFnl}") private String spStgToFnl;
	@Value("${cms.possessApptmnt.run.report}") private boolean runReport;

	public CMSTimeOfPossessionAppointment() {

	}
	
	@PostConstruct
	public void construct() {
		super.setSearchPath(searchPath);
		super.setIntgType(intgType);
		super.setFileName(fileName);
		super.setReportName(reportName);
		super.setParmNum(parmNum);
		super.setRvpName(rvpName);
		super.setRptIteration(rptIteration);
		super.setDateInterval(dateInterval);
		super.setEndDate(endDate);
		super.setSpTruncate(spTruncate);
		super.setSpStgToFnl(spStgToFnl);
		super.setRunReport(runReport);
	}
	
}
