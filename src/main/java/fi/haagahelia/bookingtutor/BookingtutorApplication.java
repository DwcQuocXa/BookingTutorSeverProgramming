package fi.haagahelia.bookingtutor;

import java.text.SimpleDateFormat;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import fi.haagahelia.bookingtutor.domain.LanguageEntity;
import fi.haagahelia.bookingtutor.domain.LessonEntity;
import fi.haagahelia.bookingtutor.domain.TutorEntity;
import fi.haagahelia.bookingtutor.domain.User;
import fi.haagahelia.bookingtutor.repository.LanguageRepository;
import fi.haagahelia.bookingtutor.repository.LessonRepository;
import fi.haagahelia.bookingtutor.repository.TutorRepository;
import fi.haagahelia.bookingtutor.repository.UserRepository;

@SpringBootApplication
public class BookingtutorApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingtutorApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(LessonRepository lessonRepository, LanguageRepository langRepository,
			TutorRepository tutorRepository, UserRepository userRepository) {
		return (args) -> {

			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			langRepository.save(new LanguageEntity("Java"));
			langRepository.save(new LanguageEntity("C#"));
			langRepository.save(new LanguageEntity("Javascript"));
			langRepository.save(new LanguageEntity("Scala"));
			langRepository.save(new LanguageEntity("Python"));
			langRepository.save(new LanguageEntity("HTML"));
			langRepository.save(new LanguageEntity("React"));
			langRepository.save(new LanguageEntity("Spring Boot"));

			tutorRepository.save(new TutorEntity("Katie Nguyen", "Third year IT student at Aalto Univeristy"));
			tutorRepository.save(new TutorEntity("Nguyen Pham", "Frontend Trainee at Futurice"));
			tutorRepository.save(new TutorEntity("Cristiano Smith", "Second year BIT student at Haaga-Helia UAS"));
			tutorRepository.save(new TutorEntity("Duc Ngo", "Junior Software engineer at WeAre"));
			tutorRepository.save(new TutorEntity("Markus Leppa", "Software engineer tutor at University of Helsinki"));

			lessonRepository.save(new LessonEntity(format.parse("2022-06-16"), "15:00", "18:00", "Arentikuja 1D304", 4,
					langRepository.findByName("Javascript").get(0),
					tutorRepository.findByName("Nguyen Pham").get(0), true));
			lessonRepository.save(new LessonEntity(format.parse("2022-06-12"), "09:00", "13:00", "Hamenkatu 10A", 5,
					langRepository.findByName("C#").get(0), tutorRepository.findByName("Katie Nguyen").get(0), true));
			lessonRepository.save(new LessonEntity(format.parse("2022-06-18"), "19:00", "21:30", "Aurakatu 123", 3,
					langRepository.findByName("React").get(0), tutorRepository.findByName("Duc Ngo").get(0),
					true));
			lessonRepository.save(new LessonEntity(format.parse("2022-06-22"), "14:00", "16:00", "Yo kyla  5D7", 4,
					langRepository.findByName("Javascript").get(0), tutorRepository.findByName("Duc Ngo").get(0),
					true));
			lessonRepository.save(new LessonEntity(format.parse("2022-06-25"), "12:00", "15:30", "California 123A.34",
					3, langRepository.findByName("Spring Boot").get(0),
					tutorRepository.findByName("Cristiano Smith").get(0), true));
			lessonRepository.save(new LessonEntity(format.parse("2022-06-27"), "14:00", "16:00", "Yo kyla  5D7", 5,
					langRepository.findByName("Python").get(0), tutorRepository.findByName("Duc Ngo").get(0),
					true));

			userRepository
					.save(new User("user", "$2a$12$s2o56wF5pgbNkr0LHlxqCexUOVfRCtEMeexv3Uf7TcYW8eknRgyxy", "USER"));
			userRepository
					.save(new User("admin", "$2a$12$QpjCHS132R4zF5o5y..bBekkc1.S0VHkoutY/biDkyE8TvlHT.7uK", "ADMIN"));
		};
	}
}
