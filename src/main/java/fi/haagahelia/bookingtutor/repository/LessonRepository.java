package fi.haagahelia.bookingtutor.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import fi.haagahelia.bookingtutor.domain.LessonEntity;

public interface LessonRepository extends JpaRepository<LessonEntity, Long> {
    List<LessonEntity> findById(int id);
}
