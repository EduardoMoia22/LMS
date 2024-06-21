package com.eduardo.LMS.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardo.LMS.models.TransactionModel;

public interface TransactionRepository extends JpaRepository<TransactionModel, String> {
      List<TransactionModel> findAllByUser(String userId);
}
