package com.eduardo.LMS.mappers;

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
                        userModel.getRegistrationDate());
      }

      public static UserModel entityToDBModel(UserEntity userEntity) {
            return new UserModel(
                        userEntity.getId(),
                        userEntity.getName(),
                        userEntity.getEmail(),
                        userEntity.getPhoneNumber(),
                        userEntity.getAddress(),
                        userEntity.getMembershipType(),
                        userEntity.getRegistrationDate());
      }
}
