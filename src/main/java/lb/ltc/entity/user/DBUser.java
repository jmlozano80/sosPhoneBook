package lb.ltc.entity.user;

import java.io.Serializable;

/**
 * This class defines the entity DBUser with theirs getters and setters
 * @author Jose
 *
 */
public class DBUser implements Serializable
{
	//variables
	private String email;
	private String password;
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
			 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
	
	
}//end class
