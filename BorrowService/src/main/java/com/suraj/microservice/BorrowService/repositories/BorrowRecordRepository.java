package com.suraj.microservice.BorrowService.repositories;

import com.suraj.microservice.BorrowService.entities.BorrowRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowRecordRepository extends JpaRepository<BorrowRecord, Integer> {
}
