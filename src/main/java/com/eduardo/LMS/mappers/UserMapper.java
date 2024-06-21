package com.eduardo.LMS.mappers;

import java.time.LocalDateTime;

import com.eduardo.LMS.DTOs.user.UserRequestDTO;
import com.eduardo.LMS.entities.UserEntity;
import com.eduardo.LMS.models.UserModel;

public class UserMapper {
      public static UserEntity DBModelToEntity(UserModel userModel) {
            return new UserEntity(
                        userModel.getId(),
                        userModel.getName(),
                        userModel.getEmail(),
                        userModel.getPhoneNumber(),
                        userModel.getAddress(),
                        userModel.getMembershipType(),
                        userModel.getRegistrationDate(),
                        userModel.getFines());
      }

      public static UserModel entityToDBModel(UserEntity userEntity) {
            return new UserModel(
                        userEntity.getId(),
                        userEntity.getName(),
                        userEntity.getEmail(),
                        userEntity.getPhoneNumber(),
                        userEntity.getAddress(),
                        userEntity.getMembershipType(),
                        userEntity.getRegistrationDate(),
                        userEntity.getFines());
      }

      public static UserEntity requestDTOToEntity(UserRequestDTO userRequestDTO) {
            return new UserEntity(
                        null,
                        userRequestDTO.name(),
                        userRequestDTO.email(),
                        userRequestDTO.phoneNumber(),
                        userRequestDTO.address(),
                        userRequestDTO.membershipType(),
                        LocalDateTime.now(),
                        null);
      }
}
