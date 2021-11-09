package com.decagon.phila.repository;

import com.decagon.phila.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);

    Optional<User> findByPasswordResetToken(String token);

    List<User> findAllByPasswordResetTokenIsNotNull();
}
