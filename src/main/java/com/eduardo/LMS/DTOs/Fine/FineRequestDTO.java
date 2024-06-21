package com.eduardo.LMS.DTOs.Fine;

import java.time.LocalDateTime;

public record FineRequestDTO(
            Integer amountInCents,
            LocalDateTime dueDate,
            LocalDateTime paymentDate,
            String status,
            String userId,
            String transactionId) {
}
