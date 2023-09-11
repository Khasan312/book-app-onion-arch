package com.example.bookapp.application.books;

import com.example.bookapp.domain.authors.Author;
import com.example.bookapp.domain.publishing_houses.PublishingHouse;

import java.util.UUID;

public class BookBy {

    private final UUID author;
    private final UUID publishingHouse;

    public BookBy(UUID author, UUID publishingHouse) {
        this.author = author;
        this.publishingHouse = publishingHouse;
    }

    public UUID getAuthor() {
        return author;
    }

    public UUID getPublishingHouse() {
        return publishingHouse;
    }
}
