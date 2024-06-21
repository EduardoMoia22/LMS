package com.eduardo.LMS.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardo.LMS.models.UserModel;

public interface UserRepository extends JpaRepository<UserModel, String> {
      Optional<UserModel> findByEmail(String email);
}
