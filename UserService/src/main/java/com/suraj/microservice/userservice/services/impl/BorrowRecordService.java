package com.suraj.microservice.userservice.services.impl;

import com.suraj.microservice.userservice.dto.BorrowRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "BORROW-SERVICE")
public interface BorrowRecordService {

    @GetMapping("/borrow-record/user/{userId}")
    List<BorrowRecord> getBorrowRecords(@PathVariable int userId);
}
