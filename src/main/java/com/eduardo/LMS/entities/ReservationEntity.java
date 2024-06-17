package com.eduardo.LMS.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter()
@AllArgsConstructor()
@NoArgsConstructor()
public class ReservationEntity {
      private String id;
      private BookEntity book;
      private UserEntity user;
      private LocalDateTime reservationDate;
      private LocalDateTime expiryDate;
}
