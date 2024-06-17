package com.eduardo.LMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardo.LMS.models.ReservationModel;

@Repository()
public interface ReservationRepository extends JpaRepository<ReservationModel, String> {
      
}
