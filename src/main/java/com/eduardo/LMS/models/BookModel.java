package com.eduardo.LMS.models;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter()
@Setter()
@NoArgsConstructor()
@AllArgsConstructor()
@Entity()
@Table(name = "books")
public class BookModel implements Serializable{
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
