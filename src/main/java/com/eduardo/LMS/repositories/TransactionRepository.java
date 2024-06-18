package com.eduardo.LMS.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.LMS.models.TransactionModel;

@Repository()
public interface TransactionRepository extends JpaRepository<TransactionModel, String> {
      List<TransactionModel> findAllByUser(String userId);
}
