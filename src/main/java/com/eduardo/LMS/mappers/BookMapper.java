package com.eduardo.LMS.mappers;

import com.eduardo.LMS.DTOs.book.BookRequestDTO;
import com.eduardo.LMS.DTOs.book.BookResponseDTO;
import com.eduardo.LMS.entities.BookEntity;
import com.eduardo.LMS.models.BookModel;

public class BookMapper {
      public static BookEntity DBModelToEntity(BookModel bookModel) {
            return new BookEntity(
                        bookModel.getId(),
                        bookModel.getTitle(),
                        bookModel.getAuthor(),
                        bookModel.getISBN(),
                        bookModel.getPublisher(),
                        bookModel.getPublicationYear(),
                        bookModel.getCategory(),
                        bookModel.getStatus(),
                        bookModel.getShelfLocation());
      }

      public static BookModel entityToDBModel(BookEntity bookEntity) {
            return new BookModel(
                        bookEntity.getId(),
                        bookEntity.getTitle(),
                        bookEntity.getAuthor(),
                        bookEntity.getISBN(),
                        bookEntity.getPublisher(),
                        bookEntity.getPublicationYear(),
                        bookEntity.getCategory(),
                        bookEntity.getStatus(),
                        bookEntity.getShelfLocation());
      }

      public static BookEntity requestDTOToEntity(BookRequestDTO bookRequestDTO) {
            return new BookEntity(
                        null,
                        bookRequestDTO.title(),
                        bookRequestDTO.author(),
                        bookRequestDTO.ISBN(),
                        bookRequestDTO.publisher(),
                        bookRequestDTO.publicationYear(),
                        bookRequestDTO.category(),
                        bookRequestDTO.status(),
                        bookRequestDTO.shelfLocation());
      }

      public static BookResponseDTO entityToBookResponseDTO(BookEntity bookEntity) {
            return new BookResponseDTO(
                        bookEntity.getId(),
                        bookEntity.getTitle(),
                        bookEntity.getAuthor(),
                        bookEntity.getISBN(),
                        bookEntity.getPublisher(),
                        bookEntity.getPublicationYear(),
                        bookEntity.getCategory(),
                        bookEntity.getStatus());
      }
}
