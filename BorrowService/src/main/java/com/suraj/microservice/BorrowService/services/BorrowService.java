package com.suraj.microservice.BorrowService.services;

import com.suraj.microservice.BorrowService.entities.BorrowRecord;

import java.util.List;

public interface BorrowService {
    BorrowRecord borrowBook(BorrowRecord borrowRecord);

    List<BorrowRecord> getAllBorrowRecords();

    BorrowRecord getBorrowRecordByUserId();

    BorrowRecord getBorrowRecordByBookId();
}
