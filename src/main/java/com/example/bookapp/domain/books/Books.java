package com.example.bookapp.domain.books;

import com.example.bookapp.domain.tags.Tag;

import java.util.List;
import java.util.UUID;

public interface Books {
    void add(Book book);
    void update(Book book);
    Book getByUuid(UUID uuid);
    void delete(Book book);
    List<Book> filterByTag(Tag tag, String sort, UUID authorUuid, UUID publisherUuid);
}
