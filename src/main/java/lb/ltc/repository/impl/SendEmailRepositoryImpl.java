package lb.ltc.repository.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import lb.ltc.email.GmailSender;
import lb.ltc.repository.SendEmailRepository;

@Component("SendEmailRepository")
@Repository
public class SendEmailRepositoryImpl implements SendEmailRepository{

	@Override
	public boolean sendEmail(String message)
	{ 	boolean emailSent=false; 
		String subject="Feed Back from SOS-PhoneBook";
		String sender="sosphonebook@gmail.com";
		String recipients="sosphonebook@gmail.com";
		String body=message;
		GmailSender gmailSender=new GmailSender();
		
	
		if(gmailSender.sendMail(subject, body, sender, recipients)) emailSent=true;
		
		
		return emailSent;
	}

}
