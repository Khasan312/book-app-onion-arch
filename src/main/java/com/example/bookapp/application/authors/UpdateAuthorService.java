package com.example.bookapp.application.authors;

import com.example.bookapp.domain.authors.Author;
import com.example.bookapp.domain.authors.Authors;

public class UpdateAuthorService {
    private final Authors authors;


    public UpdateAuthorService(Authors authors) {
        this.authors = authors;
    }

    public AuthorDTO updateAuthor(UpdateAuthorInput input) {
        String name = input.name;
        Author author = this.authors.getByUuid(input.uuid);
        author.updateAuthor(name);
        this.authors.update(author);

        return AuthorDTO.from(author);
    }
}
