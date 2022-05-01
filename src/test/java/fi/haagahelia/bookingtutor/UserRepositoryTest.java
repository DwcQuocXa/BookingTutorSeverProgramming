package fi.haagahelia.bookingtutor;

import static org.assertj.core.api.Assertions.assertThat;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.bookingtutor.repository.UserRepository;
import fi.haagahelia.bookingtutor.domain.User;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void findByUserNameShouldReturnUser() {

        User users = userRepository.findByUsername("user");

        assertThat(users.getRole()).isEqualTo("USER");
    }

    @Test
    public void addNewUser() {
        User user = new User("test", "HelloWorld", "TesingtRole");
        userRepository.save(user);
        assertThat(user.getId()).isNotNull();
    }

}