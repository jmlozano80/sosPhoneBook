package lb.ltc.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import lb.ltc.entity.user.Contact;
import lb.ltc.repository.ContactRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

	@Autowired
	private ContactRepository contactRepository;
	
	
	public boolean newContact(final String email, final String contactName,final String contactNumber) {
		boolean contactCreated = contactRepository.newContact(email, contactName,contactNumber);
		
		return contactCreated;
	}
	
	
	public List<Contact>listOfContacts(String email)
	{    
		System.out.println("HOLA FROM CONTACTservice listOfContacts(String email) ");
		
		
		return contactRepository.listOfContacts(email);
	}
	
	
	public boolean deletedContact(String email,String contactNumber)
	{
		System.out.println("HOLA FROM COnTACT service method deletedContact ");
		
		return contactRepository.contactDeleted(email, contactNumber);
	}
}
