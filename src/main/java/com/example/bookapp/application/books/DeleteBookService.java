package com.example.bookapp.application.books;

import com.example.bookapp.domain.books.Book;
import com.example.bookapp.domain.books.Books;

public class DeleteBookService {
    private final Books books;

    public DeleteBookService(Books books) {
        this.books = books;
    }

    public void deleteBook(DeleteBookInput input) {
        Book book = this.books.getByUuid(input.getUuid());
        this.books.delete(book);
    }
}
