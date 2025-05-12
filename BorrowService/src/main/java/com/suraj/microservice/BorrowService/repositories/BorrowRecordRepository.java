package com.suraj.microservice.BorrowService.repositories;

import com.suraj.microservice.BorrowService.entities.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Integer> {
    List<BorrowRecord> getBorrowRecordByUserId(int userId);

    List<BorrowRecord> getBorrowRecordByBookId(int bookId);
}
