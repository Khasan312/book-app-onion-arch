package com.example.bookapp.application.books;

import com.example.bookapp.domain.authors.Author;
import com.example.bookapp.domain.authors.Authors;
import com.example.bookapp.domain.books.Book;
import com.example.bookapp.domain.books.Books;
import com.example.bookapp.domain.publishing_houses.PublishingHouse;
import com.example.bookapp.domain.publishing_houses.PublishingHouses;
import jakarta.transaction.Transactional;

public class CreateBookService {
    private final Authors authors;
    private final PublishingHouses publishingHouses;
    private final Books books;

    public CreateBookService(Authors authors, PublishingHouses publishingHouses, Books books) {
        this.authors = authors;
        this.publishingHouses = publishingHouses;
        this.books = books;
    }

    @Transactional
    public Book createBook(CreateBookInput input) {
        Author author = this.authors.getByUuid(input.bookBy().getAuthor());
        PublishingHouse publishingHouse = this.publishingHouses.getByUuid(input.bookBy().getPublishingHouse());



        Book book = new Book(input.info().title(),
                input.info().quantity(),
                input.info().year(),
                author,
                publishingHouse);
        this.books.add(book);

        return book;


    }
}
