package lb.ltc.service;

import lb.ltc.repository.SendEmailRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendEmailService {

	@Autowired
	private SendEmailRepository sendEmailRepository;
	
	
	
	public boolean sendEmail(final String message) {
		boolean messageSent = sendEmailRepository.sendEmail(message);
		
		return messageSent;
	
	
}
}