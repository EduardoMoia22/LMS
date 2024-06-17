package com.eduardo.LMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.LMS.models.FineModel;

@Repository()
public interface FineRepository extends JpaRepository<FineModel, String> {
      
}
