package com.eduardo.LMS.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter()
@NoArgsConstructor()
@AllArgsConstructor()
public class UserEntity {
      private String id;
      private String name;
      private String email;
      private String phoneNumber;
      private String address;
      private String membershipType;
      private LocalDateTime registrationDate;
}
