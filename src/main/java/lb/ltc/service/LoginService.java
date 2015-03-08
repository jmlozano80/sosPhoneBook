package lb.ltc.service;

import lb.ltc.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService 
{
	@Autowired
	private UserRepository userRepository;
	
	
	
	public boolean authenticateUser(final String email, final String password) {
		boolean loginPass = userRepository.authenticateUser(email, password);
		
		return loginPass;
	}
}
