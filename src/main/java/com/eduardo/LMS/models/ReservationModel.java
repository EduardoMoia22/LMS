package com.eduardo.LMS.models;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Getter()
@Setter()
@NoArgsConstructor()
@AllArgsConstructor()
public class ReservationModel {
      @Id()
      @GeneratedValue(strategy = GenerationType.UUID)
      private String id;
      private BookModel book;
      private UserModel user;
      private LocalDateTime reservationDate;
      private LocalDateTime expiryDate;
}
