package com.eduardo.LMS.DTOs.book;

public record BookRequestDTO(
            String title,
            String author,
            String ISBN,
            String publisher,
            Integer publicationYear,
            String category,
            String status,
            String shelfLocation) {

}
