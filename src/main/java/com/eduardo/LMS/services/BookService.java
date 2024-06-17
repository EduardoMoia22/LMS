package com.eduardo.LMS.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.eduardo.LMS.DTOs.book.BookRequestDTO;
import com.eduardo.LMS.entities.BookEntity;
import com.eduardo.LMS.mappers.BookMapper;
import com.eduardo.LMS.models.BookModel;
import com.eduardo.LMS.repositories.BookRepository;

public class BookService {
      @Autowired
      private BookRepository bookRepository;

      public BookEntity createBook(BookRequestDTO bookData) {
            BookEntity book = BookMapper.requestDTOToEntity(bookData);

            this.bookRepository.save(BookMapper.entityToDBModel(book));

            return book;
      }

      public List<BookEntity> listAllBooks() {
            List<BookModel> allBooks = this.bookRepository.findAll();

            return allBooks.stream()
                        .map(BookMapper::DBModelToEntity)
                        .collect(Collectors.toList());
      }

      public BookEntity findBookById(String id) throws Exception {
            Optional<BookModel> book = this.bookRepository.findById(id);

            if (!book.isPresent()) {
                  throw new Exception("Livro não encontrado.");
            }

            return BookMapper.DBModelToEntity(book.get());
      }
}