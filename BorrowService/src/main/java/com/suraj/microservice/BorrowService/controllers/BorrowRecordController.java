package com.suraj.microservice.BorrowService.controllers;

import com.suraj.microservice.BorrowService.entities.BorrowRecord;
import com.suraj.microservice.BorrowService.services.BorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/borrow-record")
public class BorrowRecordController {
    @Autowired
    private BorrowService borrowService;

    @PostMapping
    public ResponseEntity<BorrowRecord> createBorrowRecord(@RequestBody BorrowRecord borrowRecord) {
        return new ResponseEntity<>(borrowService.borrowBook(borrowRecord), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BorrowRecord>> getAllBorrowRecords() {
        return new ResponseEntity<>(borrowService.getAllBorrowRecords(), HttpStatus.OK);
    }

    @GetMapping("/{borrowId}")
    public ResponseEntity<BorrowRecord> getBorrowRecordById(@PathVariable int borrowId) {
        BorrowRecord record = borrowService.getBorrowRecordById(borrowId);
        if (record == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(record, HttpStatus.OK);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BorrowRecord>> getBorrowRecordByUserId(@PathVariable int userId) {
        return new ResponseEntity<>(borrowService.getBorrowRecordByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("/book/{bookId}")
    public ResponseEntity<List<BorrowRecord>> getBorrowRecordByBookId(@PathVariable int bookId) {
        return new ResponseEntity<>(borrowService.getBorrowRecordByBookId(bookId), HttpStatus.OK);
    }
}
