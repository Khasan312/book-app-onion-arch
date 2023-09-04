package com.example.bookapp.application.books;

public class BookInfo {
    private final String title;
    private final int quantity;
    private final int year;

    public BookInfo(String title, int quantity, int year) {
        this.title = title;
        this.quantity = quantity;
        this.year = year;
    }

    public String title() {
        return title;
    }

    public int quantity() {
        return quantity;
    }

    public int year() {
        return year;
    }
}
