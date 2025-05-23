package com.suraj.microservice.BookService.services.impl;

import com.suraj.microservice.BookService.entities.Book;
import com.suraj.microservice.BookService.exceptions.BookNotFoundException;
import com.suraj.microservice.BookService.repositories.BookRepository;
import com.suraj.microservice.BookService.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book getBookById(int id) {
        return bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException("Book with id " + id + " doesn't exist!"));
    }

    @Override
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book, int id) {
        Book updatedBook = getBookById(id);
        updatedBook.setTitle(book.getTitle());
        updatedBook.setCategory(book.getCategory());
        updatedBook.setAvailableCopies(book.getAvailableCopies());
        updatedBook.setTotalCopies(book.getTotalCopies());

        return bookRepository.save(updatedBook);
    }
}
