package com.example.bookapp.infrastructure.books.controllers.requests;

import java.util.UUID;

public class UpdateBookRequest {
    public UUID uuid;
    public String title;
    public int quantity;
    public int year;
    public UUID author;
    public UUID publishingHouse;
}
