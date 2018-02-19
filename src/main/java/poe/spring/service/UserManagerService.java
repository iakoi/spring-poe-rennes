package poe.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import poe.spring.domain.User;
import poe.spring.repository.UserRepository;

@Service
public class UserManagerService {

	@Autowired
	private UserRepository userRepository;

	public User signup(String login, String password) {

		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		
		userRepository.save(user);

		return user;
	}
}
