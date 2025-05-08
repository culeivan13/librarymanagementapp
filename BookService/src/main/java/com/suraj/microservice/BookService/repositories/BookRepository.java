package com.suraj.microservice.BookService.repositories;

import com.suraj.microservice.BookService.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Integer> {
}
