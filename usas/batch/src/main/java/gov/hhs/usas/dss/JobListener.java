package gov.hhs.usas.dss;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:report.properties")
public class JobListener extends JobExecutionListenerSupport {

	@Autowired
	private EmailService emailService;
	
	private String jobName;
	private String exitStatus;	
	private Map<String,Object> parametersMap;
	
	private static final Logger log = LoggerFactory.getLogger(JobListener.class);
	
	@Value("${send.email.notification}")
	private boolean sendEmailNotification;
	
	@Value("${ihs.vac.report.name}")
	private String ihsVacReport;
	
	@Value("${offer.report.name}")
	private String offerReport;
	
	@Value("${staff.report.name}")
	private String staffReport;
	
	@Value("${app.report.name}")
	private String appReport;
	
	@Value("${ann.report.name}")
	private String annReport;
	
	@Value("${cert.report.name}")
	private String certReport;
	
	@Value("${newHire.report.name}")
	private String newHireReport;
	
	@Value("${rqst.report.name}")
	private String rqstReport;
	
	@Value("${rvw.report.name}")
	private String rvwReport;
	
	@Value("${task.report.name}")
	private String taskReport;
	
	@Value("${vac.report.name}")
	private String vacReport;

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
			parametersMap.put(ihsVacReport, jobExecution.getExecutionContext().get(ihsVacReport));
			parametersMap.put(offerReport, jobExecution.getExecutionContext().get(offerReport));
			parametersMap.put(staffReport, jobExecution.getExecutionContext().get(staffReport));
			parametersMap.put(appReport, jobExecution.getExecutionContext().get(appReport));
			parametersMap.put(annReport, jobExecution.getExecutionContext().get(annReport));
			parametersMap.put(certReport, jobExecution.getExecutionContext().get(certReport));
			parametersMap.put(newHireReport, jobExecution.getExecutionContext().get(newHireReport));
			parametersMap.put(rqstReport, jobExecution.getExecutionContext().get(rqstReport));
			parametersMap.put(rvwReport, jobExecution.getExecutionContext().get(rvwReport));
			parametersMap.put(taskReport, jobExecution.getExecutionContext().get(taskReport));
			parametersMap.put(vacReport, jobExecution.getExecutionContext().get(vacReport));
		
		if (sendEmailNotification) {
			try {
				emailService.sendHTMLEmail(jobName, exitStatus, parametersMap);
			} catch (MessagingException e) {
				log.info(e.getMessage() + "::" + e.getCause());
			}
		}
	}
}
