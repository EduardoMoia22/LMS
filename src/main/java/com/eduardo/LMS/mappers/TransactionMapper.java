package com.eduardo.LMS.mappers;

import com.eduardo.LMS.entities.TransactionEntity;
import com.eduardo.LMS.models.TransactionModel;

public class TransactionMapper {
      public static TransactionEntity DBModelToEntity(TransactionModel transactionModel) {
            return new TransactionEntity(
                        transactionModel.getId(),
                        BookMapper.DBModelToEntity(transactionModel.getBook()),
                        UserMapper.DBModelToEntity(transactionModel.getUser()),
                        LibrarianMapper.DBModelToEntity(transactionModel.getLibrarian()),
                        transactionModel.getTransactionType(),
                        transactionModel.getTransactionDate(),
                        transactionModel.getDueDate(),
                        transactionModel.getReturnDate());
      }

      public static TransactionModel entityToDBModel(TransactionEntity transactionEntity) {
            return new TransactionModel(
                        transactionEntity.getId(),
                        BookMapper.entityToDBModel(transactionEntity.getBook()),
                        UserMapper.entityToDBModel(transactionEntity.getUser()),
                        LibrarianMapper.entityToDBModel(transactionEntity.getLibrarian()),
                        transactionEntity.getTransactionType(),
                        transactionEntity.getTransactionDate(),
                        transactionEntity.getDueDate(),
                        transactionEntity.getReturnDate());
      }
}
