package com.example.bookapp.domain.authors;

import java.util.List;
import java.util.UUID;

public interface Authors {
    void add(Author author);
    Long countByName(String name);
    Author getByUuid(UUID uuid);
    Author getByName(String name);
    void update(Author author);
    List<Author> getAll();
    void delete(Author author);
}
