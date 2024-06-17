package com.eduardo.LMS.models;

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
public class BookModel {
      @Id()
      @GeneratedValue(strategy = GenerationType.UUID)
      private String id;
      private String title;
      private String author;
      private String ISBN;
      private String publisher;
      private Integer publicationYear;
      private String category;
      private String status;
      private String shelfLocation;
}
