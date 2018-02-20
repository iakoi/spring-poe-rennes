package poe.spring.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import poe.spring.domain.User;
import poe.spring.repository.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserManagerServiceTests {

    @Autowired
    UserManagerService userManagerService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void checkUserCreation() {

        assertThat(userRepository.count()).isEqualTo(0);

        // enregistre un nouvel utilisateur en BDD
        String login = "jean";
        User createdUser = userManagerService.signup(login, "secret");

        assertThat(createdUser).isNotNull();
        assertThat(createdUser.getId()).isNotNull().isGreaterThan(0);

        // récupération de l'utilisateur en base de données
        long createdUserId = createdUser.getId();
        User user = userRepository.findOne(createdUserId);

        // vérifications
        assertThat(user).isNotNull();
        assertThat(user.getLogin()).isEqualTo(login);
    }
}
