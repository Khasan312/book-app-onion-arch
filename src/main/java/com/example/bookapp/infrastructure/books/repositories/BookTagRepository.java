package com.example.bookapp.infrastructure.books.repositories;

import com.example.bookapp.domain.books.Book;
import com.example.bookapp.domain.books.BookTag;
import com.example.bookapp.domain.books.BookTags;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class BookTagRepository implements BookTags {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(BookTag bookTag) {
        this.entityManager.merge(bookTag);
        this.entityManager.flush();
    }

    @Override
    public void remove(BookTag tag) {
        this.entityManager.remove(tag);
    }

    @Override
    public List<BookTag> getAllByBook(Book book) {
        return this.entityManager.createQuery(
                "SELECT b FROM BookTag b WHERE b.book = :book", BookTag.class
        ).setParameter("book", book).getResultList();
    }
}
