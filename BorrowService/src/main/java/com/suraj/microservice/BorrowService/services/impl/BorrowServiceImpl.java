package com.suraj.microservice.BorrowService.services.impl;

import com.suraj.microservice.BorrowService.entities.BorrowRecord;
import com.suraj.microservice.BorrowService.repositories.BorrowRecordRepository;
import com.suraj.microservice.BorrowService.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowServiceImpl implements BorrowService {

    @Autowired
    private BorrowRecordRepository borrowRecordRepository;

    @Override
    public BorrowRecord borrowBook(BorrowRecord borrowRecord) {
        return borrowRecordRepository.save(borrowRecord);
    }

    @Override
    public List<BorrowRecord> getAllBorrowRecords() {
        return borrowRecordRepository.findAll();
    }

    @Override
    public BorrowRecord getBorrowRecordById(int borrowId) {
        return borrowRecordRepository.findById(borrowId).orElse(null);
    }

    @Override
    public List<BorrowRecord> getBorrowRecordByUserId(int userId) {
        return borrowRecordRepository.getBorrowRecordByUserId(userId);
    }

    @Override
    public List<BorrowRecord> getBorrowRecordByBookId(int bookId) {
        return borrowRecordRepository.getBorrowRecordByBookId(bookId);
    }
}
