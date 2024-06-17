package com.eduardo.LMS.DTOs.book;

public record BookResponseDTO(
            String id,
            String title,
            String author,
            String ISBN,
            String publisher,
            Integer publicationYear,
            String category,
            String status,
            String shelfLocation) {

}
