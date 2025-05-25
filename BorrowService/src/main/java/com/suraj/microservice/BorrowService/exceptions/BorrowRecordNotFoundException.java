package com.suraj.microservice.BorrowService.exceptions;

public class BorrowRecordNotFoundException extends RuntimeException {
    public BorrowRecordNotFoundException(String message) {
        super(message);
    }

    public BorrowRecordNotFoundException() {
        super("Borrow record doesn't exist!");
    }
}
