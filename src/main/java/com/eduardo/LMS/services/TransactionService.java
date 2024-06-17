package com.eduardo.LMS.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.LMS.DTOs.Transaction.TransactionRequestDTO;
import com.eduardo.LMS.entities.BookEntity;
import com.eduardo.LMS.entities.LibrarianEntity;
import com.eduardo.LMS.entities.TransactionEntity;
import com.eduardo.LMS.entities.UserEntity;
import com.eduardo.LMS.mappers.TransactionMapper;
import com.eduardo.LMS.repositories.TransactionRepository;

@Service()
public class TransactionService {
      @Autowired()
      private TransactionRepository transactionRepository;

      @Autowired()
      private UserService userService;

      @Autowired()
      private BookService bookService;

      @Autowired()
      private LibrarianService librarianService;

      public Boolean processTransaction(TransactionRequestDTO transactionData) throws Exception {
            BookEntity book = this.bookService.findBookById(transactionData.bookId());

            if (!book.checkAvilability()) {
                  return false;
            }

            TransactionEntity transaction = TransactionMapper.requestDTOToEntity(transactionData);
            UserEntity user = this.userService.findUserById(transactionData.userId());
            LibrarianEntity librarian = this.librarianService.findLibrarianById(transactionData.librarianId());

            transaction.setUser(user);
            transaction.setBook(book);
            transaction.setLibrarian(librarian);

            this.transactionRepository.save(TransactionMapper.entityToDBModel(transaction));
            this.bookService.borrowBook(book.getId());

            return true;
      }
}
