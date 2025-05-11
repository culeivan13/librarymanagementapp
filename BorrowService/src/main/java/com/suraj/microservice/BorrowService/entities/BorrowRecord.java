package com.suraj.microservice.BorrowService.entities;

import com.suraj.microservice.BorrowService.model.BorrowStatus;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class BorrowRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "borrow_record_id")
    private int id;
    private Long userId;  // From User Service
    private Long bookId;  // From Book Service

    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    @Enumerated(EnumType.STRING)
    private BorrowStatus status;
}
