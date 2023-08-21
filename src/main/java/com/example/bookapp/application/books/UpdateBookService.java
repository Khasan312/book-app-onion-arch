package com.example.bookapp.application.books;

import com.example.bookapp.domain.authors.Author;
import com.example.bookapp.domain.authors.Authors;
import com.example.bookapp.domain.books.Book;
import com.example.bookapp.domain.books.Books;
import com.example.bookapp.domain.publishing_houses.PublishingHouse;
import com.example.bookapp.domain.publishing_houses.PublishingHouses;

public class UpdateBookService {
    private final Authors authors;
    private final PublishingHouses publishingHouses;
    private final Books books;

    public UpdateBookService(Authors authors, PublishingHouses publishingHouses, Books books) {
        this.authors = authors;
        this.publishingHouses = publishingHouses;
        this.books = books;
    }

    public BookDTO updateBook(UpdateBookInput input) {

        Author author = this.authors.getByUuid(input.bookBy().getAuthor());
        PublishingHouse publishingHouse =
                this.publishingHouses.getByUuid(input.bookBy().getPublishingHouse());
        Book book = this.books.getByUuid(input.uuid());

        if (book == null) {
            throw new RuntimeException("Book with UUID '" + input.uuid() + "' not found.");
        }
        book.updateBook(input.info().title(),
                input.info().quantity(),
                input.info().year());
        book.updateBy(author, publishingHouse);
        this.books.update(book);

        return BookDTO.from(book);
    }
}
