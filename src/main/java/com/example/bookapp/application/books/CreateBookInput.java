package com.example.bookapp.application.books;

import com.example.bookapp.domain.tags.Tags;

import java.util.List;
import java.util.UUID;

public class CreateBookInput {
    private final BookInfo info;
    private final BookBy bookBy;
    private final List<UUID> tags;

    public CreateBookInput(BookInfo info, BookBy bookBy, List<UUID> tags) {
        this.info = info;
        this.bookBy = bookBy;
        this.tags = tags;
    }

    public BookInfo info() {
        return info;
    }

    public BookBy bookBy() {
        return bookBy;
    }

    public List<UUID> tags() {
        return tags;}


}
