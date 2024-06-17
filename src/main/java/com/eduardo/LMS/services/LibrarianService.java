package com.eduardo.LMS.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardo.LMS.DTOs.librarian.LibrarianRequestDTO;
import com.eduardo.LMS.entities.LibrarianEntity;
import com.eduardo.LMS.mappers.LibrarianMapper;
import com.eduardo.LMS.models.LibrarianModel;
import com.eduardo.LMS.repositories.LibrarianRepository;

@Service()
public class LibrarianService {
      @Autowired()
      private LibrarianRepository librarianRepository;

      public LibrarianEntity createLibrarian(LibrarianRequestDTO librarianData) {
            LibrarianModel librarian = this.librarianRepository
                        .save(LibrarianMapper.entityToDBModel(LibrarianMapper.requestDTOToEntity(librarianData)));

            return LibrarianMapper.DBModelToEntity(librarian);
      }

      public LibrarianEntity findLibrarianById(String id) throws Exception {
            Optional<LibrarianModel> librarian = this.librarianRepository.findById(id);

            if (!librarian.isPresent()) {
                  throw new Exception("Bibliotecário não encontrado.");
            }

            return LibrarianMapper.DBModelToEntity(librarian.get());
      }

      public List<LibrarianEntity> listAllLibrarians() {
            List<LibrarianModel> allLibrarians = this.librarianRepository.findAll();

            return allLibrarians.stream()
                        .map(LibrarianMapper::DBModelToEntity)
                        .collect(Collectors.toList());
      }
}
