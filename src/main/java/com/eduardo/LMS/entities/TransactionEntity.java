package com.eduardo.LMS.entities;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter()
@AllArgsConstructor()
@NoArgsConstructor()
public class TransactionEntity {
      private String id;
      private BookEntity book;
      private UserEntity user;
      private LibrarianEntity librarian;
      private String transactionType;
      private LocalDateTime transactionDate;
      private LocalDateTime dueDate;
      private LocalDateTime returnDate;
}
