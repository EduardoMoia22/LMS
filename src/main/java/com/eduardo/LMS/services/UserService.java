package com.eduardo.LMS.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.LMS.DTOs.user.UserRequestDTO;
import com.eduardo.LMS.entities.UserEntity;
import com.eduardo.LMS.mappers.UserMapper;
import com.eduardo.LMS.models.UserModel;
import com.eduardo.LMS.repositories.UserRepository;

@Service()
public class UserService {
      @Autowired()
      private UserRepository userRepository;

      public UserEntity createUser(UserRequestDTO userData) throws Exception {
            if (this.userAlreadyExists(userData.email())) {
                  throw new Exception(
                              "Já existe um usuário cadastrado com esse endereço de email. Tente utilizar outro.");
            }

            UserModel user = this.userRepository
                        .save(UserMapper.entityToDBModel(UserMapper.requestDTOToEntity(userData)));

            return UserMapper.DBModelToEntity(user);
      }

      public UserEntity findUserById(String id) throws Exception {
            Optional<UserModel> user = this.userRepository.findById(id);

            if (!user.isPresent()) {
                  throw new Exception("Usuário não encontrado.");
            }

            return UserMapper.DBModelToEntity(user.get());
      }

      public List<UserEntity> listAllUsers() {
            List<UserModel> allUsers = this.userRepository.findAll();

            return allUsers.stream()
                        .map(UserMapper::DBModelToEntity)
                        .collect(Collectors.toList());
      }

      protected Boolean userAlreadyExists(String email) {
            Optional<UserModel> user = this.userRepository.findByEmail(email);

            return user.isPresent();
      }

}
