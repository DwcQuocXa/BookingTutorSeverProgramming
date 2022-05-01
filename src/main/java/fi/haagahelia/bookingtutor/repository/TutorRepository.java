package fi.haagahelia.bookingtutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import fi.haagahelia.bookingtutor.domain.TutorEntity;
import java.util.List;

public interface TutorRepository extends JpaRepository<TutorEntity, Long> {
    List<TutorEntity> findByName(String name);
}
