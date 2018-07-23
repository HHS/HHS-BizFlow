package gov.hhs.usas.dss;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:whrsc-report.properties")
public class WHRSCJobListener extends JobExecutionListenerSupport {

	@Autowired
	private EmailService emailService;	
	@Autowired
	Properties properties;
	
	private String jobName;
	private String exitStatus;	
	private Map<String,Object> parametersMap;
	
	private static final Logger log = LoggerFactory.getLogger(WHRSCJobListener.class);

	
	//Callback before a job executes.
	@Override
	public void beforeJob(JobExecution jobExecution) {
	}

	//Callback after completion of a job. Called after both both successful and failed executions.
	@Override
	public void afterJob(JobExecution jobExecution) {
		this.jobName = jobExecution.getJobInstance().getJobName();
		this.exitStatus = jobExecution.getExitStatus().getExitCode().toString().replace("exitCode=", " "); 	

		this.parametersMap = new HashMap<String,Object>();
			parametersMap.put(properties.getAnReportName(), jobExecution.getExecutionContext().get(properties.getAnReportName()));
			parametersMap.put(properties.getClReportName(), jobExecution.getExecutionContext().get(properties.getClReportName()));
			parametersMap.put(properties.getcReportName(), jobExecution.getExecutionContext().get(properties.getcReportName()));
			parametersMap.put(properties.getPpReportName(), jobExecution.getExecutionContext().get(properties.getPpReportName()));
			parametersMap.put(properties.getNhfReportName(), jobExecution.getExecutionContext().get(properties.getNhfReportName()));
			parametersMap.put(properties.getNhodReportName(), jobExecution.getExecutionContext().get(properties.getNhodReportName()));
			parametersMap.put(properties.getNhtReportName(), jobExecution.getExecutionContext().get(properties.getNhtReportName()));
			parametersMap.put(properties.getNhvrReportName(), jobExecution.getExecutionContext().get(properties.getNhvrReportName()));
			parametersMap.put(properties.getNhReportName(), jobExecution.getExecutionContext().get(properties.getNhReportName()));
			parametersMap.put(properties.getRlReportName(), jobExecution.getExecutionContext().get(properties.getRlReportName()));
			parametersMap.put(properties.getRrcReportName(), jobExecution.getExecutionContext().get(properties.getRrcReportName()));
			parametersMap.put(properties.getRvcReportName(), jobExecution.getExecutionContext().get(properties.getRvcReportName()));
			parametersMap.put(properties.getReqReportName(), jobExecution.getExecutionContext().get(properties.getReqReportName()));
			parametersMap.put(properties.getVacReportName(), jobExecution.getExecutionContext().get(properties.getVacReportName()));
			parametersMap.put(properties.getVeReportName(), jobExecution.getExecutionContext().get(properties.getVeReportName()));
			parametersMap.put(properties.getVlReportName(), jobExecution.getExecutionContext().get(properties.getVlReportName()));
			parametersMap.put(properties.getVmcoReportName(), jobExecution.getExecutionContext().get(properties.getVmcoReportName()));
			parametersMap.put(properties.getVrcReportName(), jobExecution.getExecutionContext().get(properties.getVrcReportName()));
		
		if (properties.sendEmailNotification()) {
			try {
				//emailService.sendHTMLEmail(properties.getEmailFrom(), properties.getEmailTo(), properties.getEmailSubject(), properties.getHtmlMessage(), jobName, exitStatus, parametersMap);
				emailService.sendHTMLEmail(jobName, exitStatus, parametersMap);
				
			} catch (MessagingException e) {
				log.info(e.getMessage() + "::" + e.getCause());
			}
		}
	}
}
