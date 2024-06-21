package com.eduardo.LMS.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter()
@NoArgsConstructor()
@AllArgsConstructor()
public class UserEntity {
      private String id;
      private String name;
      private String email;
      private String phoneNumber;
      private String address;
      private String membershipType;
      private LocalDateTime registrationDate;
      private List<FineEntity> fines;

      public void addFine(FineEntity fine) {
            this.fines.add(fine);
      }

      public List<FineEntity> getFinesByTransaction(String transactionId) {
            return this.fines.stream()
                        .filter(fine -> fine.getTransaction().getId().equals(transactionId))
                        .collect(Collectors.toList());
      }
}
