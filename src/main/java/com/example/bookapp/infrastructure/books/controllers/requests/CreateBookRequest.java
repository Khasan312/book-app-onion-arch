package com.example.bookapp.infrastructure.books.controllers.requests;

import java.util.UUID;

public class CreateBookRequest {
    public String title;
    public UUID author;
    public UUID publishingHouse;
    public int quantity;
    public int year;
}
