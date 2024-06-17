package com.eduardo.LMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.LMS.models.BookModel;

@Repository()
public interface BookRepository extends JpaRepository<BookModel, String> {
      
}
