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

import com.eduardo.LMS.DTOs.librarian.LibrarianRequestDTO;
import com.eduardo.LMS.entities.LibrarianEntity;
import com.eduardo.LMS.services.LibrarianService;

@RestController()
@RequestMapping("/api/v1/librarians")
public class LibrarianController {
      @Autowired()
      private LibrarianService librarianService;

      @PostMapping()
      public ResponseEntity<LibrarianEntity> createLibrarian(@RequestBody LibrarianRequestDTO librarianData) {
            LibrarianEntity librarian = this.librarianService.createLibrarian(librarianData);

            return ResponseEntity.ok(librarian);
      }

      @GetMapping()
      public ResponseEntity<List<LibrarianEntity>> listAllLibrarians() {
            List<LibrarianEntity> allLibrarians = this.librarianService.listAllLibrarians();

            return ResponseEntity.ok(allLibrarians);
      }

      @GetMapping("/{id}")
      public ResponseEntity<LibrarianEntity> findLibrarianById(@PathVariable String id) throws Exception {
            LibrarianEntity librarian = this.librarianService.findLibrarianById(id);

            return ResponseEntity.ok(librarian);
      }
}
