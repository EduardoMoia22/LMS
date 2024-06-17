package com.eduardo.LMS.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eduardo.LMS.DTOs.user.UserRequestDTO;
import com.eduardo.LMS.entities.UserEntity;
import com.eduardo.LMS.services.UserService;

@RestController()
@RequestMapping("/api/v1/users")
public class UserController {
      @Autowired()
      private UserService userService;

      @PostMapping()
      public ResponseEntity<UserEntity> createUser(@RequestBody UserRequestDTO userData) throws Exception {
            UserEntity user = this.userService.createUser(userData);
            return ResponseEntity.ok(user);
      }
}
