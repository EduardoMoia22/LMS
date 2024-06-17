package com.eduardo.LMS.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.LMS.DTOs.book.BookRequestDTO;
import com.eduardo.LMS.DTOs.book.BookResponseDTO;
import com.eduardo.LMS.entities.BookEntity;
import com.eduardo.LMS.mappers.BookMapper;
import com.eduardo.LMS.services.BookService;

@RestController()
@RequestMapping("/api/v1/books")
public class BookController {
      @Autowired()
      private BookService bookService;

      @PostMapping()
      public ResponseEntity<BookResponseDTO> createBook(@RequestBody BookRequestDTO bookData) {
            BookEntity book = this.bookService.createBook(bookData);

            return ResponseEntity.ok(BookMapper.entityToBookResponseDTO(book));
      }

      @GetMapping()
      public ResponseEntity<List<BookResponseDTO>> listAllBooks() {
            List<BookEntity> allBooks = this.bookService.listAllBooks();

            return ResponseEntity.ok(allBooks.stream()
                        .map(BookMapper::entityToBookResponseDTO)
                        .collect(Collectors.toList()));
      }

      @GetMapping("/{id}")
      public ResponseEntity<BookResponseDTO> findBookById(@PathVariable String id) throws Exception {
            BookEntity book = this.bookService.findBookById(id);

            return ResponseEntity.ok(BookMapper.entityToBookResponseDTO(book));
      }
}
