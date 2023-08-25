package com.example.bookapp.domain.books;

import java.util.UUID;

public interface Books {
    void add(Book book);
    void update(Book book);
    Book getByUuid(UUID uuid);
    void delete(Book book);
}
