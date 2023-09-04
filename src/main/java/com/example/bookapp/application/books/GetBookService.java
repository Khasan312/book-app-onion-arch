package com.example.bookapp.application.books;

import com.example.bookapp.domain.books.Book;
import com.example.bookapp.domain.books.Books;

public class GetBookService {
    private final Books books;

    public GetBookService(Books books) {
        this.books = books;
    }

    public BookDTO getBook(GetBookInput input) {
        Book book = this.books.getByUuid(input.uuid());
        return BookDTO.from(book);
    }
}
