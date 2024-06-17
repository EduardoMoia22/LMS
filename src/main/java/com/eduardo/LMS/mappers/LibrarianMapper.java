package com.eduardo.LMS.mappers;

import com.eduardo.LMS.DTOs.librarian.LibrarianRequestDTO;
import com.eduardo.LMS.entities.LibrarianEntity;
import com.eduardo.LMS.models.LibrarianModel;

public class LibrarianMapper {
      public static LibrarianEntity DBModelToEntity(LibrarianModel librarianModel) {
            return new LibrarianEntity(
                        librarianModel.getId(),
                        librarianModel.getName(),
                        librarianModel.getEmail(),
                        librarianModel.getPhoneNumber(),
                        librarianModel.getEmployeeId());
      }

      public static LibrarianModel entityToDBModel(LibrarianEntity librarianEntity) {
            return new LibrarianModel(
                        librarianEntity.getId(),
                        librarianEntity.getName(),
                        librarianEntity.getEmail(),
                        librarianEntity.getPhoneNumber(),
                        librarianEntity.getEmployeeId());
      }
      
      public static LibrarianEntity requestDTOToEntity(LibrarianRequestDTO librarianRequestDTO){
            return new LibrarianEntity(
                  null,
                  librarianRequestDTO.name(),
                  librarianRequestDTO.email(),
                  librarianRequestDTO.phoneNumber(),
                  librarianRequestDTO.employeeId()
            );
      }
}
