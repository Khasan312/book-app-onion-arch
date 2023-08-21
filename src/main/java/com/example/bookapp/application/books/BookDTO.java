package com.example.bookapp.application.books;

import com.example.bookapp.domain.books.Book;

import java.util.UUID;

public class BookDTO {
    private UUID uuid;
    private String title;
    private int quantity;
    private int year;

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
