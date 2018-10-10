package gov.hhs.batch;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Properties {

	//Cron Schedule of Jobs
	@Value("${ehrp.cron.sched}")
	private String ehrpCronSchedule;
	@Value("${biis.cron.sched}")
	private String biisCronSchedule;
	
	//Run Batch Jobs-True or False
	@Value("${run.ehrp.job}")
	private String runEhrpJob;
	@Value("${run.biis.job}")
	private String runBiisJob;

	//Email Properties
	@Value("${send.biis.email.notification}")
	private String sendBiisEmailNotification;
	@Value("${send.ehrp.email.notification}")
	private String sendEhrpEmailNotification;			
			
	@Value("${email.subject}")
	private String emailSubjectTemplate;
	@Value("${email.message}")
	private String emailMessageTemplate;
	@Value("${email.html.message}")
	private String emailHTMLMessageTemplate;
	@Value("${emailid.from}")
	private String from;
	@Value("${emailid.to}")
	private String[] to;
	
	public String getEhrpCronSchedule() {
		return ehrpCronSchedule;
	}
	public void setEhrpCronSchedule(String ehrpCronSchedule) {
		this.ehrpCronSchedule = ehrpCronSchedule;
	}
	public String getBiisCronSchedule() {
		return biisCronSchedule;
	}
	public void setBiisCronSchedule(String biisCronSchedule) {
		this.biisCronSchedule = biisCronSchedule;
	}	
	public String getRunEhrpJob() {
		return runEhrpJob;
	}
	public void setRunEhrpJob(String runEhrpJob) {
		this.runEhrpJob = runEhrpJob;
	}
	public String getRunBiisJob() {
		return runBiisJob;
	}
	public void setRunBiisJob(String runBiisJob) {
		this.runBiisJob = runBiisJob;
	}
	public String getSendBiisEmailNotification() {
		return sendBiisEmailNotification;
	}
	public void setSendBiisEmailNotification(String sendBiisEmailNotification) {
		this.sendBiisEmailNotification = sendBiisEmailNotification;
	}
	public String getSendEhrpEmailNotification() {
		return sendEhrpEmailNotification;
	}
	public void setSendEhrpEmailNotification(String sendEhrpEmailNotification) {
		this.sendEhrpEmailNotification = sendEhrpEmailNotification;
	}
	public String getEmailSubjectTemplate() {
		return emailSubjectTemplate;
	}
	public void setEmailSubjectTemplate(String emailSubjectTemplate) {
		this.emailSubjectTemplate = emailSubjectTemplate;
	}
	public String getEmailMessageTemplate() {
		return emailMessageTemplate;
	}
	public void setEmailMessageTemplate(String emailMessageTemplate) {
		this.emailMessageTemplate = emailMessageTemplate;
	}
	public String getEmailHTMLMessageTemplate() {
		return emailHTMLMessageTemplate;
	}
	public void setEmailHTMLMessageTemplate(String emailHTMLMessageTemplate) {
		this.emailHTMLMessageTemplate = emailHTMLMessageTemplate;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String[] getTo() {
		return to;
	}
	public void setTo(String[] to) {
		this.to = to;
	}
		
}
