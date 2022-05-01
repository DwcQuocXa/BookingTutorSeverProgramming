package fi.haagahelia.bookingtutor;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.bookingtutor.domain.TutorEntity;
import fi.haagahelia.bookingtutor.repository.TutorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TutorRepositoryTests {

    @Autowired
    private TutorRepository tutorRepository;

    @Test
    public void findByNameShouldReturnTutor() {

        List<TutorEntity> tutor = tutorRepository.findByName("Duc Ngo");
        assertThat(tutor).hasSize(1);
        assertThat(tutor.get(0).getId()).isNotNull();
    }

    @Test
    public void deleteTutor() {
        List<TutorEntity> tutor = tutorRepository.findByName("Nguyen Pham");
        assertThat(tutor).hasSize(1);
        tutorRepository.deleteById((long) 11);
        tutor = tutorRepository.findByName("Nguyen Pham");
        assertThat(tutor).hasSize(0);
    }

}