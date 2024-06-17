package com.eduardo.LMS.DTOs.Transaction;

import java.time.LocalDateTime;

public record TransactionRequestDTO(
            String bookId,
            String userId,
            String librarianId,
            String transactionType,
            LocalDateTime transactionDate,
            LocalDateTime dueDate,
            LocalDateTime returnDate) {

}
