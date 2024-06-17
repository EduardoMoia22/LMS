package com.eduardo.LMS.mappers;

import com.eduardo.LMS.entities.FineEntity;
import com.eduardo.LMS.models.FineModel;

public class FineMapper {
      public static FineEntity DBModelToEntity(FineModel fineModel) {
            return new FineEntity(
                        fineModel.getId(),
                        UserMapper.DBModelToEntity(fineModel.getUser()),
                        fineModel.getAmount(),
                        fineModel.getDueDate(),
                        fineModel.getStatus());
      }

      public static FineModel entityToDBModel(FineEntity fineEntity) {
            return new FineModel(
                        fineEntity.getId(),
                        UserMapper.entityToDBModel(fineEntity.getUser()),
                        fineEntity.getAmount(),
                        fineEntity.getDueDate(),
                        fineEntity.getStatus());
      }
}
