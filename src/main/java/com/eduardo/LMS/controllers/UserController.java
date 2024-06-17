package com.eduardo.LMS.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

      @GetMapping()
      public ResponseEntity<List<UserEntity>> listAllUsers() {
            List<UserEntity> allUsers = this.userService.listAllUsers();

            return ResponseEntity.ok(allUsers);
      }

      @GetMapping("/{id}")
      public ResponseEntity<UserEntity> findUserById(@PathVariable String id) throws Exception {
            UserEntity user = this.userService.findUserById(id);
            
            return ResponseEntity.ok(user);
      }
}
