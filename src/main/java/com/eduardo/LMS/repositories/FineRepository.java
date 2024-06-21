package com.eduardo.LMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardo.LMS.models.FineModel;

public interface FineRepository extends JpaRepository<FineModel, String> {
      
}
