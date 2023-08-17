package com.example.bookapp.infrastructure.books.repositories;

import com.example.bookapp.domain.books.Book;
import com.example.bookapp.domain.books.Books;
import com.example.bookapp.infrastructure.authors.repositories.AuthorRepository;
import com.example.bookapp.infrastructure.publishing_houses.repositories.PublishingHouseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
@Transactional
public class BookRepository implements Books {
    @PersistenceContext
    private EntityManager entityManager;
    private final AuthorRepository authorRepository;
    private final PublishingHouseRepository publishingHouseRepository;

    public BookRepository(AuthorRepository authorRepository,
                          PublishingHouseRepository publishingHouseRepository) {
        this.authorRepository = authorRepository;
        this.publishingHouseRepository = publishingHouseRepository;
    }

    @Override
    public void add(Book book) {
        this.entityManager.merge(book);
        this.entityManager.flush();
    }

    @Override
    public void update(Book book) {

    }

    @Override
    public Book getByUuid(UUID uuid) {
        return this.entityManager
                .createQuery("SELECT b FROM Book b WHERE b.uuid = :uuid", Book.class)
                .setParameter("uuid", uuid)
                .getSingleResult();
    }
}
