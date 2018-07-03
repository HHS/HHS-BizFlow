package gov.hhs.usas.dss;


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
import org.springframework.beans.factory.annotation.Value;
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


	public void sendEmail(String jobName, String exitStatus, Map<String,Object> parametersMap){

		String interfaceName = BatchConfiguration.getInterfaceName();
		String parameters = parametersMap.toString();

		this.emailSubject = emailSubjectTemplate.replace("DATE_TODAY", dateFormat.format(today)).replace("INTERFACE_NAME", interfaceName).replace("JOB_NAME", jobName).replace("STATUS", exitStatus);

		this.emailMessage = emailMessageTemplate.replace("JOB_NAME", jobName).replace("STATUS", exitStatus).replace("PARAMETERS", parameters);

		this.mail = new SimpleMailMessage();
		this.mail.setSubject(emailSubject);
		this.mail.setText(emailMessage);
		this.mail.setFrom(from);


		for(String recipient : to){
			this.mail.setTo(recipient);
			try {
				this.javaMailSender.send(mail);
			} catch (MailException e) {
				log.error(e.getMessage() + "::" + e.getCause());
			}
		}

	}
	
	public void sendHTMLEmail(String jobName, String exitStatus,  Map<String,Object> parametersMap) throws MessagingException {

		String interfaceName = BatchConfiguration.getInterfaceName();
		
		String tableHTML = "";
		
		Iterator<Map.Entry<String, Object>> entries = parametersMap.entrySet().iterator();
		while (entries.hasNext()) {
		    Map.Entry<String, Object> entry = entries.next();
		    tableHTML= tableHTML + "<tr><td>" + entry.getKey() + "</td><td>" + entry.getValue() + "</td></tr>";
		}

		this.emailSubject = emailSubjectTemplate.replace("DATE_TODAY", dateFormat.format(today)).replace("INTERFACE_NAME", interfaceName).replace("JOB_NAME", jobName).replace("STATUS", exitStatus);

		this.emailHTMLMessage = emailHTMLMessageTemplate.replace("[TABLE]", tableHTML);
			
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
		
		helper.setFrom(from);
		helper.setSubject(emailSubject);
		helper.setSentDate(new Date());
		helper.setText("", emailHTMLMessage);

		for(String recipient : to){
			helper.setTo(new InternetAddress(recipient));
			try {
				this.javaMailSender.send(mimeMessage);
			} catch (MailException e) {
				log.error(e.getMessage() + "::" + e.getCause());
			}
		}


	}
}

