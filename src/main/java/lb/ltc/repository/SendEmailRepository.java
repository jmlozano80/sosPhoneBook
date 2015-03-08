package lb.ltc.repository;

/**
 * This is the interface with 1 method send email 
 * @author lb
 *
 */
public interface SendEmailRepository {

	boolean sendEmail(String message);
	
	
}
