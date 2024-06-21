package com.eduardo.LMS.mappers;

import com.eduardo.LMS.DTOs.Fine.FineRequestDTO;
import com.eduardo.LMS.entities.FineEntity;
import com.eduardo.LMS.models.FineModel;

public class FineMapper {
      public static FineEntity DBModelToEntity(FineModel fineModel) {
            return new FineEntity(
                        fineModel.getId(),
                        fineModel.getAmount(),
                        fineModel.getDueDate(),
                        fineModel.getPaymentDate(),
                        fineModel.getStatus(),
                        UserMapper.DBModelToEntity(fineModel.getUser()),
                        TransactionMapper.DBModelToEntity(fineModel.getTransaction()));
      }

      public static FineModel entityToDBModel(FineEntity fineEntity) {
            return new FineModel(
                        fineEntity.getId(),
                        fineEntity.getAmountInCents(),
                        fineEntity.getDueDate(),
                        fineEntity.getPaymentDate(),
                        fineEntity.getStatus(),
                        UserMapper.entityToDBModel(fineEntity.getUser()),
                        TransactionMapper.entityToDBModel(fineEntity.getTransaction()));
      }

      public static FineEntity requestDTOToEntity(FineRequestDTO fineRequestDTO) {
            return new FineEntity(
                        null,
                        fineRequestDTO.amountInCents(),
                        fineRequestDTO.dueDate(),
                        fineRequestDTO.paymentDate(),
                        fineRequestDTO.status(),
                        null,
                        null);
      }
}
