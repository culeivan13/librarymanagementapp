package com.suraj.microservice.BorrowService.services;

import com.suraj.microservice.BorrowService.entities.BorrowRecord;

import java.util.List;

public interface BorrowService {
    BorrowRecord borrowBook(BorrowRecord borrowRecord);

    List<BorrowRecord> getAllBorrowRecords();

    BorrowRecord getBorrowRecordById(int borrowId);

    BorrowRecord updateBorrowRecord(BorrowRecord borrowRecord, int borrowId);

    List<BorrowRecord> getBorrowRecordByUserId(int userId);

    List<BorrowRecord> getBorrowRecordByBookId(int bookId);

    BorrowRecord getBorrowRecordByUserIdAndBookId(int userId, int bookId);
}
