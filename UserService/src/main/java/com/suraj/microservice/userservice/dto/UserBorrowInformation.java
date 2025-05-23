package com.suraj.microservice.userservice.dto;

import java.util.List;

public class UserBorrowInformation {
    private String name;
    private String email;
    private List<BorrowInformation> borrowInformation;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<BorrowInformation> getBorrowInformation() {
        return borrowInformation;
    }

    public void setBorrowInformation(List<BorrowInformation> borrowInformation) {
        this.borrowInformation = borrowInformation;
    }

    @Override
    public String toString() {
        return "UserBorrowInformation{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", borrowInformation=" + borrowInformation +
                '}';
    }
}
