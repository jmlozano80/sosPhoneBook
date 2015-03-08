package lb.ltc.entity.user;

import java.io.Serializable;
/**
 * This class defines the entity Contact with theirs getters and setters
 * @author Jose
 *
 */
public class Contact implements Serializable{
    private String email;
    private String contactName;
    private String contactNumber;
    
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
}
