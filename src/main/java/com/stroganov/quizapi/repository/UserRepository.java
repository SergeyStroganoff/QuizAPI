package com.stroganov.quizapi.repository;

import com.stroganov.quizapi.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
