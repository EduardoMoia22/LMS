package com.eduardo.LMS.DTOs.user;

public record UserRequestDTO(
            String name,
            String email,
            String phoneNumber,
            String address,
            String membershipType) {
}
