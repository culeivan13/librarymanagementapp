package com.suraj.microservice.userservice.dto;

import java.time.LocalDate;

public class BorrowRecord {
    private int id;
    private int userId;  // From User Service
    private int bookId;  // From Book Service
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private BorrowStatus status;

    public BorrowRecord(int userId, int bookId, LocalDate borrowDate, LocalDate dueDate, LocalDate returnDate, BorrowStatus status) {
        this.userId = userId;
        this.bookId = bookId;
        this.borrowDate = borrowDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    public BorrowRecord() {
    }

    public int getId() {
        return id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public BorrowStatus getStatus() {
        return status;
    }

    public void setStatus(BorrowStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BorrowRecord{" + "id=" + id + ", userId=" + userId + ", bookId=" + bookId + ", borrowDate=" + borrowDate + ", dueDate=" + dueDate + ", returnDate=" + returnDate + ", status=" + status + '}';
    }
}
