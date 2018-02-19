package poe.spring.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import poe.spring.domain.User;
import poe.spring.service.UserManagerService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

	@Autowired
	UserManagerService userManagerService;

	@PostMapping
	public User save(@RequestBody User user) {
		User savedUser = userManagerService.signup(user.getLogin(), user.getPassword());
		System.out.println("user id sqsq: " + savedUser);
		return savedUser;
	}
}
