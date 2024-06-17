package com.eduardo.LMS.mappers;

import com.eduardo.LMS.entities.ReservationEntity;
import com.eduardo.LMS.models.ReservationModel;

public class ReservationMapper {
      public static ReservationEntity DBModelToEntity(ReservationModel reservationModel) {
            return new ReservationEntity(
                        reservationModel.getId(),
                        BookMapper.DBModelToEntity(reservationModel.getBook()),
                        UserMapper.DBModelToEntity(reservationModel.getUser()),
                        reservationModel.getReservationDate(),
                        reservationModel.getExpiryDate());
      }

      public static ReservationModel entityToDBModel(ReservationEntity reservationEntity) {
            return new ReservationModel(
                        reservationEntity.getId(),
                        BookMapper.entityToDBModel(reservationEntity.getBook()),
                        UserMapper.entityToDBModel(reservationEntity.getUser()),
                        reservationEntity.getReservationDate(),
                        reservationEntity.getExpiryDate());
      }
}
