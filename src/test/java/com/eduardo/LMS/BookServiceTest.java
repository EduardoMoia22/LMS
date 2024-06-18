package com.eduardo.LMS;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.eduardo.LMS.DTOs.book.BookRequestDTO;
import com.eduardo.LMS.entities.BookEntity;
import com.eduardo.LMS.mappers.BookMapper;
import com.eduardo.LMS.models.BookModel;
import com.eduardo.LMS.repositories.BookRepository;
import com.eduardo.LMS.services.BookService;

public class BookServiceTest {

      @InjectMocks
      private BookService bookService;

      @Mock
      private BookRepository bookRepository;

      @BeforeEach
      public void setUp() {
            MockitoAnnotations.openMocks(this);
      }

      @Test
      public void testCreateBook() {
            BookRequestDTO bookRequestDTO = new BookRequestDTO("Title", "Author", "ISBN", "Publisher", 2022, "Category",
                        "Available", "Shelf");
            BookModel bookModel = BookMapper.entityToDBModel(BookMapper.requestDTOToEntity(bookRequestDTO));

            when(bookRepository.save(any(BookModel.class))).thenReturn(bookModel);

            BookEntity result = bookService.createBook(bookRequestDTO);

            assertNotNull(result);
            assertEquals("Title", result.getTitle());
            verify(bookRepository, times(1)).save(any(BookModel.class));
      }

      @Test
      public void testListAllBooks() {
            List<BookModel> bookModels = Arrays.asList(
                        new BookModel("1", "Title1", "Author1", "ISBN1", "Publisher1", 2021, "Category1", "Available",
                                    "Shelf1"),
                        new BookModel("2", "Title2", "Author2", "ISBN2", "Publisher2", 2022, "Category2", "Borrowed",
                                    "Shelf2"));

            when(bookRepository.findAll()).thenReturn(bookModels);

            List<BookEntity> result = bookService.listAllBooks();

            assertEquals(2, result.size());
            verify(bookRepository, times(1)).findAll();
      }

      @Test
      public void testFindBookByIdSuccess() throws Exception {
            BookModel bookModel = new BookModel("1", "Title1", "Author1", "ISBN1", "Publisher1", 2021, "Category1",
                        "Available", "Shelf1");

            when(bookRepository.findById("1")).thenReturn(Optional.of(bookModel));

            BookEntity result = bookService.findBookById("1");

            assertNotNull(result);
            assertEquals("Title1", result.getTitle());
            verify(bookRepository, times(1)).findById("1");
      }

      @Test
      public void testFindBookByIdNotFound() {
            when(bookRepository.findById("1")).thenReturn(Optional.empty());

            Exception exception = assertThrows(Exception.class, () -> {
                  bookService.findBookById("1");
            });

            assertEquals("Livro não encontrado.", exception.getMessage());
            verify(bookRepository, times(1)).findById("1");
      }

      @Test
      public void testBorrowBookSuccess() throws Exception {
            BookModel bookModel = new BookModel("1", "Title1", "Author1", "ISBN1", "Publisher1", 2021, "Category1",
                        "Disponível", "Shelf1");
            when(bookRepository.findById("1")).thenReturn(Optional.of(bookModel));
            when(bookRepository.save(any(BookModel.class))).thenReturn(bookModel);

            bookService.borrowBook("1");

            ArgumentCaptor<BookModel> bookModelCaptor = ArgumentCaptor.forClass(BookModel.class);
            verify(bookRepository, times(1)).findById("1");
            verify(bookRepository, times(1)).save(bookModelCaptor.capture());

            BookModel capturedBookModel = bookModelCaptor.getValue();
            assertEquals("Emprestado", capturedBookModel.getStatus());
      }

      @Test
      public void testBorrowBookNotFound() {
            when(bookRepository.findById("1")).thenReturn(Optional.empty());

            Exception exception = assertThrows(Exception.class, () -> {
                  bookService.borrowBook("1");
            });

            assertEquals("Livro não encontrado.", exception.getMessage());
            verify(bookRepository, times(1)).findById("1");
      }
}