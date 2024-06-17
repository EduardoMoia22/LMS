package com.eduardo.LMS.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class UserModel implements Serializable{
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
