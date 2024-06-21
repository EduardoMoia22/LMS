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
      private Integer defaultFineAmountPerDayInCents = 120;

      public TransactionEntity(String id, BookEntity book, UserEntity user, LibrarianEntity librarian,
                  String transactionType, LocalDateTime transactionDate, LocalDateTime dueDate,
                  LocalDateTime returnDate) {
            this.id = id;
            this.book = book;
            this.user = user;
            this.librarian = librarian;
            this.transactionType = transactionType;
            this.transactionDate = transactionDate;
            this.dueDate = dueDate;
            this.returnDate = returnDate;
      }

      public void setUser(UserEntity user) {
            this.user = user;
      }

      public void setBook(BookEntity book) {
            this.book = book;
      }

      public void setLibrarian(LibrarianEntity librarian) {
            this.librarian = librarian;
      }

      public Boolean imposeAFineIfNecessary() {
            Integer daysOfDelay = this.returnDate.compareTo(this.dueDate);
            Integer fineAmountInCents = this.defaultFineAmountPerDayInCents * daysOfDelay;

            if (checkIfThereIsADelayInReturns()) {
                  FineEntity fine = new FineEntity(null, fineAmountInCents, LocalDateTime.now().plusMonths(1), null, "Aberto",
                              this.user, this);

                  this.user.addFine(fine);

                  return true;
            }

            return false;
      }

      private Boolean checkIfThereIsADelayInReturns() {
            if (this.returnDate.isAfter(this.dueDate)) {
                  return true;
            }

            return false;
      }

}
