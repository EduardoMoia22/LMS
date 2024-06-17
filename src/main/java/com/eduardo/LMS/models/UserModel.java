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

@Getter()
@Setter()
@NoArgsConstructor()
@AllArgsConstructor()
@Entity()
public class UserModel {
      @Id()
      @GeneratedValue(strategy = GenerationType.UUID)
      private String id;
      private String name;
      private String email;
      private String phoneNumber;
      private String address;
      private String membershipType;
      private LocalDateTime registrationDate;
}