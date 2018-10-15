package gov.hhs.batch.biis;

import java.util.HashMap;
import java.util.Map;

import javax.mail.MessagingException;

import org.slf4j.MDC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.listener.JobExecutionListenerSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import gov.hhs.batch.EmailService;
import gov.hhs.batch.Properties;

@Component
public class BIISJobListener extends JobExecutionListenerSupport {

	@Autowired
	private EmailService emailService;
	
	@Autowired
	private Properties properties;
	
	@Autowired
	private BIISProperties biisProperties;

	private String interfaceName;
	private String jobName;
	private String exitStatus;	
	private Map<String,Object> parametersMap;
	private String emailHtmlStyle;
	private String emailHtmlHeader;
	private String emailHtmlColumnH1;
	private String emailHtmlColumnH2;
	
	private static final Logger log = LoggerFactory.getLogger(BIISJobListener.class);

	//Callback before a job executes.
	@Override
	public void beforeJob(JobExecution jobExecution) {
		
		MDC.put("logFileName", biisProperties.getBiisLogFileName());
		log.info(jobExecution.getJobInstance() + "::" + jobExecution.getStatus());
	}

	//Callback after completion of a job. Called after both both successful and failed executions.
	@Override
	public void afterJob(JobExecution jobExecution) {
		this.interfaceName = biisProperties.getBiisInterfaceName();
		this.jobName = jobExecution.getJobInstance().getJobName();
		this.exitStatus = jobExecution.getExitStatus().getExitCode().toString().replace("exitCode=", " "); 
		this.emailHtmlStyle = biisProperties.getEmailHtmlStyle();
		this.emailHtmlHeader = biisProperties.getEmailHtmlHeader();
		this.emailHtmlColumnH1 = biisProperties.getEmailHtmlColumnH1();
		this.emailHtmlColumnH2 = biisProperties.getEmailHtmlColumnH2();
		
		this.parametersMap = new HashMap<String,Object>();
		parametersMap.put(biisProperties.getBiisRefDataName(), jobExecution.getExecutionContext().get(biisProperties.getBiisRefDataName()));
		parametersMap.put(biisProperties.getEhrpRefDataName(), jobExecution.getExecutionContext().get(biisProperties.getEhrpRefDataName()));
		parametersMap.put(biisProperties.getBiisPersonName(), jobExecution.getExecutionContext().get(biisProperties.getBiisPersonName()));
		
		if (Boolean.valueOf(properties.getSendBiisEmailNotification())) {
			try {
				emailService.sendHTMLEmail(interfaceName, jobName,exitStatus,parametersMap, emailHtmlStyle, emailHtmlHeader, emailHtmlColumnH1, emailHtmlColumnH2);
			} catch (MessagingException e) {
				log.info(e.getMessage() + "::" + e.getCause());
			}
		}
		log.info(jobExecution.getJobInstance() + "::" + jobExecution.getStatus() + "::" + jobExecution.getExitStatus());
		MDC.remove("logFileName");
	}
}
