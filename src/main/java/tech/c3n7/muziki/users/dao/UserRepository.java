package tech.c3n7.muziki.users.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.c3n7.muziki.users.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
}
