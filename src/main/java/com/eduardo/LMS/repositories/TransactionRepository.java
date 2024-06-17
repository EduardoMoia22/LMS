package com.eduardo.LMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.LMS.models.TransactionModel;

@Repository()
public interface TransactionRepository extends JpaRepository<TransactionModel, String> {
      
}
