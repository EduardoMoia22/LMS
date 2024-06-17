package com.eduardo.LMS.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter()
@NoArgsConstructor()
@AllArgsConstructor()
public class FineEntity {
      private String id;
      private UserEntity user;
      private Double amount;
      private LocalDateTime dueDate;
      private String status;
}
