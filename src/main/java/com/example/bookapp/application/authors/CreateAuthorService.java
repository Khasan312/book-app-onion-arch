package com.example.bookapp.application.authors;

import com.example.bookapp.domain.authors.Author;
import com.example.bookapp.domain.authors.Authors;

public class CreateAuthorService {
    private final Authors authors;


    public CreateAuthorService(Authors authors) {
        this.authors = authors;
    }

    public AuthorDTO createAuthor(CreateAuthorInput input) {
        String name = input.name();
        Author author;
        author = authors.getByName(name);

        if (author == null) {
            throw new RuntimeException("Write a valid name");
        }
        author = new Author(name);
        this.authors.add(author);
        return AuthorDTO.from(author);
    }
}
