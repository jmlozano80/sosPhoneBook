package lb.ltc.repository.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import lb.ltc.entity.user.Contact;
import lb.ltc.repository.ContactRepository;
import lb.ltc.util.HibernateUtil;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


import java.sql.*;
import org.hibernate.*;
import org.hibernate.criterion.*;

/**
 * This class implements the interface ContactRepository 
 * @author lb
 *
 */
@Component("ContactRepository")
@Repository
public class ContactRepositoryImpl implements ContactRepository
{

	@Override
	public boolean newContact(String email, String contactName,String contactNumber) {
		boolean userCreated = false;
		
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		
		System.out.println("Beginning transaction");
		session.beginTransaction();
		Contact newContact = new Contact();
 
		newContact.setEmail(email);
		newContact.setContactName(contactName);
		newContact.setContactNumber(contactNumber);
		
		session.save(newContact);
		System.out.println("Saved new contact, commiting...");
		try {
			userCreated=true;
		session.getTransaction().commit();
		session.flush();
		
		} catch (ConstraintViolationException cve) {
			System.out.println("Primary key not unique for " + contactNumber);
			return userCreated=false;
		}
		//ASK ABOUT session.close(), if we close the session how we gonna set the session attributes????????
		session.close();
		return userCreated;
	}

	
	
	
	@Override
	public List<Contact> listOfContacts(String email) {
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		
		String hql = "FROM Contact C WHERE C.email = :email ORDER BY C.contactName ASC";
	
		
		Query query = session.createQuery(hql);
		
		query.setParameter("email", email);
		
		List<Contact> contacts = Collections.checkedList(query.list(), Contact.class);
		
		for (Contact c: contacts) {
			System.out.println("Contact number: " + c.getContactNumber());
		}		
	
		//session.close();
		return contacts;
	} 




	@Override
	public boolean contactDeleted(String email, String contactNumber) {
		boolean contactDeleted=false;
		
		//org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		org.hibernate.Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		
		/* String hql = "delete from Product where name = :name";
	        Query query = session.createQuery(hql);
	        query.setString("name","Product 1");
	        int rowCount = query.executeUpdate();
	        System.out.println("Rows affected: " + rowCount);*/
		
		String hql = "delete from Contact where email = :email AND contactNumber= :contactNumber";
		
		Query query = session.createQuery(hql);
		System.out.println("Email: " + email + " Contact number: " + contactNumber);
		query.setString("email", email);
		query.setString("contactNumber", contactNumber);
		System.out.println("QUERY FROM deletedContact:"+ query.getQueryString().toString());
		
		System.out.println("Rows UpDATED: ");
		//return how rows get updated
		
		
		int rowCount= query.executeUpdate();
		
				
		System.out.println(rowCount);
		
		if(rowCount==1)
		{
			System.out.println("Contact number: "+contactNumber+" was deleted;");
			
			contactDeleted=true;
			tx.commit();
		}
		session.close(); //Not sure if I have to close
		return contactDeleted;
	
	}//end method
	
	
}//end class
