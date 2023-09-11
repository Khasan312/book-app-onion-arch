package com.example.bookapp.application.books;

import com.example.bookapp.domain.books.Book;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class BookDTO {
    private final UUID uuid;
    private final String title;
    private final int quantity;
    private final int year;

    public BookDTO(UUID uuid, String title, int quantity, int year) {
        this.uuid = uuid;
        this.title = title;
        this.quantity = quantity;
        this.year = year;
    }

    public static BookDTO from(Book book) {
        return new BookDTO(
                book.getUuid(),
                book.getTitle(),
                book.getQuantity(),
                book.getYear()
        );
    }

    public UUID getUuid() {
        return uuid;
    }
    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getYear() {
        return year;
    }
}
