package com.eduardo.LMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.LMS.models.LibrarianModel;

@Repository()
public interface LibrarianRepository extends JpaRepository<LibrarianModel, String> {
      
}
