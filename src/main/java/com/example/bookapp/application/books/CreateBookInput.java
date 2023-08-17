package com.example.bookapp.application.books;

public class CreateBookInput {
    private final BookInfo info;

    private final BookBy bookBy;

    public CreateBookInput(BookInfo info, BookBy bookBy) {
        this.info = info;
        this.bookBy = bookBy;
    }

    public BookInfo info() {
        return info;
    }

    public BookBy bookBy() {
        return bookBy;
    }


}
