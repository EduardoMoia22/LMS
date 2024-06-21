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
      private Integer amountInCents;
      private LocalDateTime dueDate;
      private String status;
      private UserEntity user;
      private TransactionEntity transaction;

      public void setUser(UserEntity user) {
            this.user = user;
      }

      public void setTransaction(TransactionEntity transaction) {
            this.transaction = transaction;
      }
}
