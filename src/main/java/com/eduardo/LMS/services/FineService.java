package com.eduardo.LMS.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.LMS.DTOs.Fine.FineRequestDTO;
import com.eduardo.LMS.entities.FineEntity;
import com.eduardo.LMS.entities.TransactionEntity;
import com.eduardo.LMS.entities.UserEntity;
import com.eduardo.LMS.mappers.FineMapper;
import com.eduardo.LMS.repositories.FineRepository;

@Service()
public class FineService {
      @Autowired()
      private FineRepository fineRepository;

      @Autowired
      private UserService userService;

      @Autowired
      private TransactionService transactionService;

      public FineEntity createFine(FineRequestDTO fineData) throws Exception {
            FineEntity fine = FineMapper.requestDTOToEntity(fineData);
            UserEntity user = this.userService.findUserById(fineData.userId());
            TransactionEntity transaction = this.transactionService.findTransactionById(fineData.transactionId());

            fine.setUser(user);
            fine.setTransaction(transaction);

            return FineMapper.DBModelToEntity(this.fineRepository.save(FineMapper.entityToDBModel(fine)));
      }

      public FineEntity createFineByEntity(FineEntity fineData) {
            return FineMapper.DBModelToEntity(this.fineRepository.save(FineMapper.entityToDBModel(fineData)));
      }
}
