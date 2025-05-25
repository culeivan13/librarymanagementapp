package com.suraj.microservice.userservice.controllers;

import com.suraj.microservice.userservice.dto.Book;
import com.suraj.microservice.userservice.dto.BorrowInformation;
import com.suraj.microservice.userservice.dto.BorrowRecord;
import com.suraj.microservice.userservice.dto.UserBorrowInformation;
import com.suraj.microservice.userservice.entities.User;
import com.suraj.microservice.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable int userId) {
        User user = userService.getUserById(userId);
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @GetMapping("/borrow-info/{userId}")
    public ResponseEntity<UserBorrowInformation> getUserBorrowInformation(@PathVariable int userId) {
        UserBorrowInformation userBorrowInformation = new UserBorrowInformation();

        // fetching the given user
        User user = userService.getUserById(userId);

        userBorrowInformation.setName(user.getName());
        userBorrowInformation.setEmail(user.getEmail());

        // fetching the borrow record from borrow service
        ResponseEntity<List<BorrowRecord>> borrowRecordResponse = restTemplate.exchange("http://BORROW-SERVICE/borrow-record/user/" + userId, HttpMethod.GET, null, new ParameterizedTypeReference<List<BorrowRecord>>() {
        });
        List<BorrowRecord> borrowRecordsByUser = borrowRecordResponse.getBody();
        List<BorrowInformation> borrowInformationList = null;
        // making borrow information list from the borrow records
        if (borrowRecordsByUser != null) {
            borrowInformationList = borrowRecordsByUser.stream().map(borrowRecord -> {
                BorrowInformation borrowInformation = new BorrowInformation();
                borrowInformation.setBorrowDate(borrowRecord.getBorrowDate());
                borrowInformation.setDueDate(borrowRecord.getDueDate());
                borrowInformation.setReturnDate(borrowRecord.getReturnDate());
                borrowInformation.setBorrowStatus(borrowRecord.getStatus().toString());

                // fetching book from the book id in the borrow record
                Book book = restTemplate.getForObject("http://BOOK-SERVICE/book/" + borrowRecord.getBookId(), Book.class);

                if (book != null) {
                    borrowInformation.setTitle(book.getTitle());
                    borrowInformation.setCategory(book.getCategory());
                }
                return borrowInformation;
            }).toList();
        }
        userBorrowInformation.setBorrowInformation(borrowInformationList);
        return new ResponseEntity<>(userBorrowInformation, HttpStatus.OK);
    }
}
