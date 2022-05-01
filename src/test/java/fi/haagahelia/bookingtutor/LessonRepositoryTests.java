package fi.haagahelia.bookingtutor;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import fi.haagahelia.bookingtutor.domain.TutorEntity;
import fi.haagahelia.bookingtutor.domain.LessonEntity;
import fi.haagahelia.bookingtutor.domain.LanguageEntity;
import fi.haagahelia.bookingtutor.repository.LanguageRepository;
import fi.haagahelia.bookingtutor.repository.LessonRepository;
import fi.haagahelia.bookingtutor.repository.TutorRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class LessonRepositoryTests {

    @Autowired
    private LessonRepository repository;

    @Test
    public void findByIdShouldReturnLesson() {
        List<LessonEntity> lessons = repository.findById(1);

        assertThat(lessons).hasSize(1);
        assertThat(lessons.get(0).getTutor()).isEqualTo("Nguyen Pham");
    }

    @Test
    public void createNewLesson() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        LessonEntity lesson = new LessonEntity(format.parse("2022-06-16"), "15:00", "18:00", "Arentikuja 1D304", 4,
                new LanguageEntity("React"), new TutorEntity("Nguyen Pham", "Frontend Trainee at Futurice"), true);

        repository.save(lesson);
        assertThat(lesson.getId()).isNotNull();
    }

}
