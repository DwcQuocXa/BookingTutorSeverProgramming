package fi.haagahelia.bookingtutor.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import fi.haagahelia.bookingtutor.domain.LanguageEntity;

public interface LanguageRepository extends JpaRepository<LanguageEntity, Long> {
    List<LanguageEntity> findByName(String name);
}
