package com.suraj.microservice.BookService.services;

import com.suraj.microservice.BookService.entities.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBooks();

    Book getBookById(int id);

    Book saveBook(Book book);

    Book updateBook(Book book, int id);
}
