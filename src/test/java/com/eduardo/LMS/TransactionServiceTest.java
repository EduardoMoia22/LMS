package com.eduardo.LMS;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.eduardo.LMS.DTOs.Transaction.TransactionRequestDTO;
import com.eduardo.LMS.entities.BookEntity;
import com.eduardo.LMS.entities.LibrarianEntity;
import com.eduardo.LMS.entities.TransactionEntity;
import com.eduardo.LMS.entities.UserEntity;
import com.eduardo.LMS.mappers.TransactionMapper;
import com.eduardo.LMS.models.TransactionModel;
import com.eduardo.LMS.repositories.TransactionRepository;
import com.eduardo.LMS.services.BookService;
import com.eduardo.LMS.services.FineService;
import com.eduardo.LMS.services.LibrarianService;
import com.eduardo.LMS.services.TransactionService;
import com.eduardo.LMS.services.UserService;

@ExtendWith(MockitoExtension.class)
public class TransactionServiceTest {

      @InjectMocks
      private TransactionService transactionService;

      @Mock
      private TransactionRepository transactionRepository;

      @Mock
      private UserService userService;

      @Mock
      private BookService bookService;

      @Mock
      private LibrarianService librarianService;

      @Mock
      private FineService fineService;

      private TransactionRequestDTO transactionRequestDTO;
      private BookEntity book;
      private UserEntity user;
      private LibrarianEntity librarian;

      @BeforeEach
      public void setUp() {
            transactionRequestDTO = new TransactionRequestDTO("bookId", "userId", "librarianId", "BORROW",
                        LocalDateTime.now(), LocalDateTime.now().plusDays(14), null);
            book = mock(BookEntity.class);
            user = mock(UserEntity.class);
            librarian = mock(LibrarianEntity.class);
      }

      @Test
      public void testProcessBorrowBookTransaction_Success() throws Exception {
            when(bookService.findBookById("bookId")).thenReturn(book);
            when(book.checkAvailability()).thenReturn(true);
            when(userService.findUserById("userId")).thenReturn(user);
            when(librarianService.findLibrarianById("librarianId")).thenReturn(librarian);

            TransactionEntity transaction = TransactionMapper.requestDTOToEntity(transactionRequestDTO);
            when(transactionRepository.save(any(TransactionModel.class))).thenReturn(new TransactionModel());

            boolean result = transactionService.processBorrowBookTransaction(transactionRequestDTO);

            verify(transactionRepository, times(1)).save(any(TransactionModel.class));
            verify(bookService, times(1)).borrowBook(book.getId());
            assert (result);
      }

      @Test
      public void testProcessBorrowBookTransaction_BookNotAvailable() throws Exception {
            when(bookService.findBookById("bookId")).thenReturn(book);
            when(book.checkAvailability()).thenReturn(false);

            boolean result = transactionService.processBorrowBookTransaction(transactionRequestDTO);

            verify(transactionRepository, times(0)).save(any(TransactionModel.class));
            verify(bookService, times(0)).borrowBook("bookId");
            assert (!result);
      }
}
