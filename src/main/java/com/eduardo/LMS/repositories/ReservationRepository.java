package com.eduardo.LMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eduardo.LMS.models.ReservationModel;

public interface ReservationRepository extends JpaRepository<ReservationModel, String> {
      
}
