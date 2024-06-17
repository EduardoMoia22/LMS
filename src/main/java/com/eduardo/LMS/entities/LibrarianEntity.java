package com.eduardo.LMS.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter()
@NoArgsConstructor()
@AllArgsConstructor()
public class LibrarianEntity {
      private String id;
      private String name;
      private String email;
      private String phoneNumber;
      private String employeeId;
}
