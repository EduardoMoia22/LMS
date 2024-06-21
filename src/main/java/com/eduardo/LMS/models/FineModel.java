package com.eduardo.LMS.models;

import java.io.Serializable;
import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Getter()
@Setter()
@NoArgsConstructor()
@AllArgsConstructor()
@Table(name = "fines")
public class FineModel implements Serializable {
      @Id()
      @GeneratedValue(strategy = GenerationType.UUID)
      private String id;
      private Integer amount;
      private LocalDateTime dueDate;
      private LocalDateTime paymentDate;
      private String status;
      @ManyToOne(fetch = FetchType.LAZY)
      @JoinColumn(name = "user_id")
      private UserModel user;
      @OneToOne
      private TransactionModel transaction;
}
