package lb.ltc.service;


import java.util.List;




import lb.ltc.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RegistrationService {
	
	@Autowired
	private UserRepository userRepository;
	
	/*public List<User> findAll() {
		return userRepository.findAll();
	}*/
	
	public boolean emailExists(final String email) {
		boolean emailExists = userRepository.emailExists(email);
		
		return emailExists;
	}
	
	public boolean newUser(final String email, final String password) {
		boolean userCreated = userRepository.newUser(email, password);
		
		return userCreated;
	}
}
