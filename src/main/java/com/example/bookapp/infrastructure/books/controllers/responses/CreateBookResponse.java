package com.example.bookapp.infrastructure.books.controllers.responses;

import com.example.bookapp.domain.books.Book;

import java.util.UUID;

public class CreateBookResponse {
    public UUID uuid;
    public String title;
    public int quantity;
    public int year;

    public static CreateBookResponse from(Book book) {
        CreateBookResponse createBookResponse = new CreateBookResponse();
        createBookResponse.uuid = book.getUuid();
        createBookResponse.title = book.getTitle();
        createBookResponse.quantity = book.getQuantity();
        createBookResponse.year = book.getYear();
        return createBookResponse;
    }
}
