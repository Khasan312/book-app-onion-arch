package com.example.bookapp.application.authors;

import com.example.bookapp.domain.authors.Author;
import com.example.bookapp.domain.authors.Authors;

public class DeleteAuthorService {
    private final Authors authors;

    public DeleteAuthorService(Authors authors) {
        this.authors = authors;
    }

    public void
    deleteAuthor(DeleteAuthorInput input) {
        Author author = this.authors.getByUuid(input.getUuid());
        this.authors.delete(author);
    }
}
