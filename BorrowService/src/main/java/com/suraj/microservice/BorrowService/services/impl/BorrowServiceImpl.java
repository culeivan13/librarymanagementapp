package com.suraj.microservice.BorrowService.services.impl;

import com.suraj.microservice.BorrowService.entities.BorrowRecord;
import com.suraj.microservice.BorrowService.exceptions.BorrowRecordNotFoundException;
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
        return borrowRecordRepository.findById(borrowId).orElseThrow(() -> new BorrowRecordNotFoundException("Borrow record with id " + borrowId + " doesn't exist!"));
    }

    @Override
    public BorrowRecord updateBorrowRecord(BorrowRecord borrowRecord, int borrowId) {
        BorrowRecord updatedBorrowRecord = getBorrowRecordById(borrowId);
        updatedBorrowRecord.setUserId(borrowRecord.getUserId());
        updatedBorrowRecord.setBookId(borrowRecord.getBookId());
        updatedBorrowRecord.setStatus(borrowRecord.getStatus());
        updatedBorrowRecord.setDueDate(borrowRecord.getDueDate());
        updatedBorrowRecord.setReturnDate(borrowRecord.getReturnDate());
        updatedBorrowRecord.setBorrowDate(borrowRecord.getBorrowDate());

        return borrowRecordRepository.save(updatedBorrowRecord);
    }

    @Override
    public List<BorrowRecord> getBorrowRecordByUserId(int userId) {
        return borrowRecordRepository.getBorrowRecordByUserId(userId);
    }

    @Override
    public List<BorrowRecord> getBorrowRecordByBookId(int bookId) {
        return borrowRecordRepository.getBorrowRecordByBookId(bookId);
    }

    @Override
    public BorrowRecord getBorrowRecordByUserIdAndBookId(int userId, int bookId) {
        return borrowRecordRepository.getBorrowRecordByUserIdAndBookId(userId, bookId).orElseThrow(() -> new BorrowRecordNotFoundException());
    }
}
