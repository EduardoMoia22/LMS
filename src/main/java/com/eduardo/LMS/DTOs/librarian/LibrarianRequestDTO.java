package com.eduardo.LMS.DTOs.librarian;

public record LibrarianRequestDTO(
            String name,
            String email,
            String phoneNumber,
            String employeeId) {

}
