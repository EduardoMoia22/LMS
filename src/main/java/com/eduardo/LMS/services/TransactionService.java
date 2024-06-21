package com.eduardo.LMS.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.LMS.DTOs.Transaction.TransactionRequestDTO;
import com.eduardo.LMS.entities.BookEntity;
import com.eduardo.LMS.entities.FineEntity;
import com.eduardo.LMS.entities.LibrarianEntity;
import com.eduardo.LMS.entities.TransactionEntity;
import com.eduardo.LMS.entities.UserEntity;
import com.eduardo.LMS.mappers.TransactionMapper;
import com.eduardo.LMS.models.TransactionModel;
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

      @Autowired()
      private FineService fineService;

      public Boolean processBorrowBookTransaction(TransactionRequestDTO transactionData) throws Exception {
            BookEntity book = this.bookService.findBookById(transactionData.bookId());

            if (!book.checkAvailability()) {
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

      public Boolean processReturnBookTransaction(String transactionId) throws Exception {
            TransactionEntity transaction = this.findTransactionById(transactionId);

            if (transaction.imposeAFineIfNecessary()) {
                  List<FineEntity> userTransactionFines = transaction.getUser()
                              .getFinesByTransaction(transaction.getId());

                  for (FineEntity fine : userTransactionFines) {
                        this.fineService.createFineByEntity(fine);
                  }
            }
            return true;
      }

      public List<TransactionEntity> listAllUserTransaction(String userId) {
            List<TransactionModel> listOfAllUserTransactions = this.transactionRepository.findAllByUser(userId);

            return listOfAllUserTransactions.stream()
                        .map(TransactionMapper::DBModelToEntity)
                        .collect(Collectors.toList());
      }

      public TransactionEntity findTransactionById(String id) throws Exception {
            Optional<TransactionModel> transaction = this.transactionRepository.findById(id);

            if (!transaction.isPresent()) {
                  throw new Exception("Empréstimo não encontrado.");
            }

            return TransactionMapper.DBModelToEntity(transaction.get());
      }
}
