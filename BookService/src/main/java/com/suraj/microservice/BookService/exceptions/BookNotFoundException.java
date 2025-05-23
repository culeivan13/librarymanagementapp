package com.suraj.microservice.BookService.exceptions;

import com.suraj.microservice.BookService.entities.Book;

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String message) {
        super(message);
    }

    public BookNotFoundException() {
        super("Book doesn't exist!");
    }
}
