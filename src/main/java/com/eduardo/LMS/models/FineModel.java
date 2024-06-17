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
public class FineModel {
      @Id()
      @GeneratedValue(strategy = GenerationType.UUID)
      private String id;
      private UserModel user;
      private Double amount;
      private LocalDateTime dueDate;
      private String status;
}
