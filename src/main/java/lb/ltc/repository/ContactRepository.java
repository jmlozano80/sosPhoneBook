package lb.ltc.repository;

import java.util.List;

import lb.ltc.entity.user.Contact;
/**
 * This is the interface with 3 methods newContact, listOfContacts and contactDeleted 
 * @author lb
 *
 */
public interface ContactRepository {

	boolean newContact(String email, String contactName,String contactNumber);
	List<Contact> listOfContacts(String email);
	boolean contactDeleted(String email,String contactNumber);
}
