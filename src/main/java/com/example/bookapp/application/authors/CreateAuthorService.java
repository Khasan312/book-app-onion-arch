package com.example.bookapp.application.authors;

import com.example.bookapp.domain.authors.Author;
import com.example.bookapp.domain.authors.Authors;

public class CreateAuthorService {
    private final Authors authors;


    public CreateAuthorService(Authors authors) {
        this.authors = authors;
    }

    public Author createAuthor(CreateAuthorInput input) {
        String name = input.name();
        Long authorCount = this.authors.countByName(name);

        Author author;

        if (authorCount != null && authorCount > 0) {
            // Author already exists, retrieve and return the existing author
            author = this.authors.getByName(name);
        } else {
            // Author doesn't exist, create a new author
            author = new Author(name);

            // Add the new author to the repository
            this.authors.add(author);
        }

        return author;
    }
}
