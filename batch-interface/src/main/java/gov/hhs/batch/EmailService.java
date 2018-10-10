package gov.hhs.batch;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Configuration
public class EmailService {

	private static final Logger log = LoggerFactory.getLogger(EmailService.class);

	@Autowired
	Properties properties;

	private String emailSubject;

	private String emailMessage;
	
	private String emailHTMLMessage;

	@Autowired
	private JavaMailSenderImpl javaMailSender;	
	private SimpleMailMessage mail;
	private DateFormat dateFormat;
	private Date today;

	@Autowired
	public EmailService(JavaMailSenderImpl javaMailSender) {
		this.javaMailSender = javaMailSender;		
		this.dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		this.today = new Date();		
	}


	public void sendEmail(String interfaceName, String jobName, String exitStatus,  Map<String,Object> parametersMap) {

		String parameters = parametersMap.toString();

		this.emailSubject = properties.getEmailSubjectTemplate().replace("DATE_TODAY", dateFormat.format(today)).replace("INTERFACE_NAME", interfaceName).replace("JOB_NAME", jobName).replace("STATUS", exitStatus);

		this.emailMessage = properties.getEmailMessageTemplate().replace("JOB_NAME", jobName).replace("STATUS", exitStatus).replace("PARAMETERS", parameters);

		this.mail = new SimpleMailMessage();
		this.mail.setSubject(emailSubject);
		this.mail.setText(emailMessage);
		this.mail.setFrom(properties.getFrom());


		for(String recipient : properties.getTo()){
			this.mail.setTo(recipient);
			try {
				this.javaMailSender.send(mail);
			} catch (MailException e) {
				log.error(e.getMessage() + "::" + e.getCause());
			}
		}

	}
	
	public void sendHTMLEmail(String interfaceName, String jobName, String exitStatus,  Map<String,Object> parametersMap, String emailHtmlStyle, String emailHtmlHeader, String emailHtmlColumnH1, String emailHtmlColumnH2) throws MessagingException {
		
		String tableHTML = "";
		
		Iterator<Map.Entry<String, Object>> entries = parametersMap.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry<String, Object> entry = entries.next();
		    tableHTML= tableHTML + "<tr><td>" + entry.getKey() + "</td><td>" + entry.getValue() + "</td></tr>";
		}

		this.emailSubject = properties.getEmailSubjectTemplate().replace("DATE_TODAY", dateFormat.format(today)).replace("INTERFACE_NAME", interfaceName).replace("JOB_NAME", jobName).replace("STATUS", exitStatus);

		this.emailHTMLMessage = properties.getEmailHTMLMessageTemplate().replace("[STYLE]", emailHtmlStyle).replace("[HEADER]", emailHtmlHeader).replace("[COLUMN_H1]", emailHtmlColumnH1).replace("[COLUMN_H2]", emailHtmlColumnH2).replace("[TABLE]", tableHTML);
			
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		
		helper.setFrom(properties.getFrom());
		helper.setSubject(emailSubject);
		helper.setSentDate(new Date());
		helper.setText("", emailHTMLMessage);

		for(String recipient : properties.getTo()){
			helper.setTo(new InternetAddress(recipient));
			try {
				this.javaMailSender.send(mimeMessage);
			} catch (MailException e) {
				log.error(e.getMessage() + "::" + e.getCause());
			}
		}
	}
}

