package com.example.bookapp.infrastructure.books.controllers.responses;

import com.example.bookapp.application.books.BookDTO;

import java.util.UUID;

public class CreateBookResponse {
    public UUID uuid;
    public String title;
    public int quantity;
    public int year;

    public static CreateBookResponse from(BookDTO bookDTO) {
        CreateBookResponse createBookResponse = new CreateBookResponse();
        createBookResponse.uuid = bookDTO.getUuid();
        createBookResponse.title = bookDTO.getTitle();
        createBookResponse.quantity = bookDTO.getQuantity();
        createBookResponse.year = bookDTO.getYear();
        return createBookResponse;
    }
}
