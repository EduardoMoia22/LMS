package com.eduardo.LMS.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter()
@NoArgsConstructor()
@AllArgsConstructor()
public class BookEntity {
      private String id;
      private String title;
      private String author;
      private String ISBN;
      private String publisher;
      private Integer publicationYear;
      private String category;
      private String status;
      private String shelfLocation;

      public Boolean checkAvilability() {
            return this.status != "Emprestado";
      }

      public void borrowBook() {
            this.status = "Emprestado";
      }

      public void returnBook() {
            this.status = "Disponível";
      }
}
