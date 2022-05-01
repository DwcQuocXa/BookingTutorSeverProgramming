package fi.haagahelia.bookingtutor.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import fi.haagahelia.bookingtutor.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
