package com.example.bookapp.infrastructure.books.controllers.responses;

import com.example.bookapp.application.books.BookDTO;

import java.util.UUID;

public class BookResponse {
    public UUID uuid;
    public String title;
    public int quantity;
    public int year;

    public static BookResponse from(BookDTO bookDTO) {
        BookResponse bookResponse = new BookResponse();
        bookResponse.uuid = bookDTO.getUuid();
        bookResponse.title = bookDTO.getTitle();
        bookResponse.quantity = bookDTO.getQuantity();
        bookResponse.year = bookDTO.getYear();
        return bookResponse;
    }
}
