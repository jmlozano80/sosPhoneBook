package lb.ltc.repository;

/**
 * This is the interface with 3 methods newUser, emailExists and authenticateUser 
 * @author lb
 *
 */

public interface UserRepository
{
	
	boolean newUser(String email, String password);
	
	boolean emailExists(String email);

	boolean authenticateUser(String email, String password);
	

}//end of interface 
