package com.eduardo.LMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardo.LMS.models.BookModel;

public interface BookRepository extends JpaRepository<BookModel, String> {
      
}
