package com.suraj.microservice.userservice.services.impl;

import com.suraj.microservice.userservice.dto.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "BOOK-SERVICE")
public interface BookService {

    @GetMapping("/book/{bookId}")
    Book getBook(@PathVariable int bookId);
}
