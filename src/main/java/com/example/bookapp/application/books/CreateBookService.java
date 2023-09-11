package com.example.bookapp.application.books;

import com.example.bookapp.domain.authors.Author;
import com.example.bookapp.domain.authors.Authors;
import com.example.bookapp.domain.books.Book;
import com.example.bookapp.domain.books.BookTag;
import com.example.bookapp.domain.books.BookTags;
import com.example.bookapp.domain.books.Books;
import com.example.bookapp.domain.publishing_houses.PublishingHouse;
import com.example.bookapp.domain.publishing_houses.PublishingHouses;
import com.example.bookapp.domain.tags.Tag;
import com.example.bookapp.domain.tags.Tags;

import java.util.List;
import java.util.UUID;

public class CreateBookService {
    private final Authors authors;
    private final PublishingHouses publishingHouses;
    private final Books books;
    private final Tags tags;
    private final BookTags bookTags;

    public CreateBookService(Authors authors, PublishingHouses publishingHouses, Books books,
            Tags tags,
            BookTags bookTags) {
        this.authors = authors;
        this.publishingHouses = publishingHouses;
        this.books = books;
        this.tags = tags;
        this.bookTags = bookTags;
    }


    public BookDTO createBook(CreateBookInput input) {
        Author author = this.authors.getByUuid(input.bookBy().getAuthor());
        PublishingHouse publishingHouse = this.publishingHouses.getByUuid(input.bookBy().getPublishingHouse());

        Book book = new Book(input.info().title(),
                input.info().quantity(),
                input.info().year(),
                author,
                publishingHouse);
        this.books.add(book);

        List<UUID> tags = input.tags();

        tags.forEach(tagUuid -> new Thread(() -> {
            Tag tag = this.tags.getByUuid(tagUuid);
            this.bookTags.add(new BookTag(book, tag));
        }).start());

        return BookDTO.from(book);


    }
}
