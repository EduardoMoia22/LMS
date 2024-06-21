package com.eduardo.LMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardo.LMS.models.LibrarianModel;

public interface LibrarianRepository extends JpaRepository<LibrarianModel, String> {
      
}
