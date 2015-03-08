package lb.ltc.repository.impl;

import javax.servlet.http.HttpSession;

import lb.ltc.entity.user.DBUser;
import lb.ltc.repository.UserRepository;
import lb.ltc.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component("UserRepository")
@Repository
public class UserRepositoryImpl implements UserRepository {

	@Override
	public boolean emailExists(String email) {

		boolean emailExists = false;
		Session hibSession = HibernateUtil.getSessionFactory().openSession();

		DBUser dbUser = (DBUser) hibSession.get(DBUser.class, email);

		if (dbUser != null && dbUser.getEmail().equals(email))
			emailExists = true;
		hibSession.close();
		return emailExists;
	}

	@Override
	public boolean newUser(String email, String password) {
		boolean userCreated = false;

		org.hibernate.Session session = HibernateUtil.getSessionFactory()
				.openSession();

		System.out.println("Beginning transaction");
		session.beginTransaction();
		DBUser newUser = new DBUser();

		newUser.setEmail(email);
		newUser.setPassword(password);

		session.save(newUser);
		System.out.println("Saved new user, commiting...");
		try {
			session.getTransaction().commit();
			session.flush();

			if (emailExists(email))
				userCreated = true;
		} catch (ConstraintViolationException cve) {
			System.out.println("Primary key not unique for " + email);
		}
		// ASK ABOUT session.close(), if we close the session how we gonna set
		// the session attributes????????
		session.close();
		return userCreated;
		
	}//end method

	@Override
	public boolean authenticateUser(String email, String password) {
		boolean userAuthenticated = false;

		Session hibSession = HibernateUtil.getSessionFactory().openSession();
		System.out.println("Authenticating user with id: " + email);
		DBUser dbUser = (DBUser) hibSession.get(DBUser.class, email);

		if (dbUser != null && dbUser.getEmail().equals(email)&& dbUser.getPassword().equals(password))
		{	userAuthenticated = true;
			System.out.println("Inside UserRepositoryImpl userAuthenticated: "+ userAuthenticated);
		}
		hibSession.close();

		return userAuthenticated;
	
	}//end method

	

}//end class