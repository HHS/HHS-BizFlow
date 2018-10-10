package gov.hhs.batch.ehrp;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.hhs.batch.EmailService;
import gov.hhs.batch.Properties;

@Component
public class EHRPJobListener extends JobExecutionListenerSupport {

	@Autowired
	private EmailService emailService;
	@Autowired
	private Properties properties;
	@Autowired
	private EHRPProperties ehrpProperties;
	
	private String interfaceName;
	private String jobName;
	private String exitStatus;	
	private Map<String,Object> parametersMap;
	
	private static final Logger log = LoggerFactory.getLogger(EHRPJobListener.class);

	//Callback before a job executes.
	@Override
	public void beforeJob(JobExecution jobExecution) {
		MDC.put("logFileName", ehrpProperties.getEhrpLogFileName());
		log.info(jobExecution.getJobInstance() + "::" + jobExecution.getStatus());
	}

	//Callback after completion of a job. Called after both both successful and failed executions.
	@Override
	public void afterJob(JobExecution jobExecution) {
		
		this.interfaceName = ehrpProperties.getEhrpInterfaceName();
		this.jobName = jobExecution.getJobInstance().getJobName();
		this.exitStatus = jobExecution.getExitStatus().getExitCode().toString().replace("exitCode=", " "); 	

		this.parametersMap = new HashMap<String,Object>();
			if (jobExecution.getExecutionContext().get(ehrpProperties.getEhrpScriptName()) != null){
				parametersMap.put(" ", (Object) ehrpProperties.getScriptErrorMsg().replace("SCRIPT", ehrpProperties.getEhrpScriptName()) + String.valueOf(jobExecution.getExecutionContext().get(ehrpProperties.getEhrpScriptName())));
			}else if (jobExecution.getExecutionContext().getString(ehrpProperties.getNoFilesName())=="false"){
				parametersMap.put(" ", (Object) ehrpProperties.getNoFilesMsg());
			}else {
				parametersMap.put(" ",(Object) ehrpProperties.getFileCountMsg().replace("COUNT", jobExecution.getExecutionContext().getString(ehrpProperties.getArchiveName())).replaceAll("NAME", ehrpProperties.getArchiveName()));
				parametersMap.put("  ", (Object) ehrpProperties.getFileCountMsg().replace("COUNT", jobExecution.getExecutionContext().getString(ehrpProperties.getErrorName())).replaceAll("NAME", ehrpProperties.getErrorName()));
			}
		
		if (Boolean.valueOf(properties.getSendEhrpEmailNotification())) {
			try {
				emailService.sendHTMLEmail(interfaceName, jobName,exitStatus,parametersMap, "", "", "", "");
			} catch (MessagingException e) {
				log.info(e.getMessage() + "::" + e.getCause());
			}
		}
		log.info(jobExecution.getJobInstance() + "::" + jobExecution.getStatus() + "::" + jobExecution.getExitStatus());
		MDC.remove("logFileName");
	}
}
