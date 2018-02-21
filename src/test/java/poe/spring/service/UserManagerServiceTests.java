package poe.spring.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import poe.spring.domain.User;
import poe.spring.repository.UserRepository;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
//@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class UserManagerServiceTests {

    @Autowired
    UserManagerService userManagerService;

    @Autowired
    UserRepository userRepository;

    @Test
    public void checkUserCreation() {

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

    @Test
    public void checkDuplicateUserCreation() {

        // enregistre un nouvel utilisateur en BDD
        String login = UUID.randomUUID().toString();
        User createdUser = userManagerService.signup(login, "secret");

        assertThat(createdUser).isNotNull();
        assertThat(createdUser.getId()).isNotNull().isGreaterThan(0);

        // récupération de l'utilisateur en base de données
        long createdUserId = createdUser.getId();
        User user = userRepository.findOne(createdUserId);

        // vérifications
        assertThat(user).isNotNull();
        assertThat(user.getLogin()).isEqualTo(login);

        // on vérifie qu'on n'a pas pu créer un user avec le même login
        User duplicateUser = userManagerService.signup(login, "secret");
        assertThat(duplicateUser).isNull();

        /// on vérifie qu'on peut toujours créer d'autres users
        assertThat(userManagerService.signup(login + "notTheSame", "secret")).isNotNull();


    }
}
