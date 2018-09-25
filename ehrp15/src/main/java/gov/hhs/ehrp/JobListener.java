package gov.hhs.ehrp;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JobListener extends JobExecutionListenerSupport {

	@Autowired
	private EmailService emailService;
	@Autowired
	private Properties properties;
	
	private String jobName;
	private String exitStatus;	
	private Map<String,Object> parametersMap;
	
	private static final Logger log = LoggerFactory.getLogger(JobListener.class);
	
	@Value("${send.email.notification}")
	private boolean sendEmailNotification;

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
			if (jobExecution.getExecutionContext().get(properties.getEhrpScriptName()) != null){
				parametersMap.put(" ", (Object) properties.getScriptErrorMsg().replace("SCRIPT", properties.getEhrpScriptName()) + String.valueOf(jobExecution.getExecutionContext().get(properties.getEhrpScriptName())));
			}else if (jobExecution.getExecutionContext().getString(properties.getNoFilesName())=="false"){
				parametersMap.put(" ", (Object) properties.getNoFilesMsg());
			}else {
				parametersMap.put(" ",(Object) properties.getFileCountMsg().replace("COUNT", jobExecution.getExecutionContext().getString(properties.getArchiveName())).replaceAll("NAME", properties.getArchiveName()));
				parametersMap.put("  ", (Object) properties.getFileCountMsg().replace("COUNT", jobExecution.getExecutionContext().getString(properties.getErrorName())).replaceAll("NAME", properties.getErrorName()));
			}
		
		if (sendEmailNotification) {
			try {
				emailService.sendHTMLEmail(jobName, exitStatus, parametersMap);
			} catch (MessagingException e) {
				log.info(e.getMessage() + "::" + e.getCause());
			}
		}
	}
}
