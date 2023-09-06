package com.example.bookapp.application.books;

import com.example.bookapp.domain.books.Books;
import com.example.bookapp.domain.tags.Tag;
import com.example.bookapp.domain.tags.Tags;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class BookListService {
    private final Tags tags;
    private final Books books;


    public BookListService(Tags tags, Books books) {
        this.tags = tags;
        this.books = books;
    }

    public List<BookDTO> getBookList(BookListInput input) {
        Tag tag = this.tags.getByUuid(input.getTagUuid());
        return this.books.filterByTag(
                tag,
                input.getSort(),
                input.getAuthorUuid(),
                input.getPublisherUuid()
        ).stream().map(book -> {
            BookDTO bookDTO = BookDTO.from(book);
            return bookDTO;
        }).collect(toList());
    }
}
