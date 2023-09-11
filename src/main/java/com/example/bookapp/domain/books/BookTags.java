package com.example.bookapp.domain.books;

import com.example.bookapp.domain.tags.Tag;

import java.util.List;

public interface BookTags {
    void add(BookTag bookTag);
    void remove(BookTag tag);
    List<BookTag> getAllByBook(Book book);
}
