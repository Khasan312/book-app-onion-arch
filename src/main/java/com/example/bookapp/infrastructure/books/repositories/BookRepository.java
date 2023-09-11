package com.example.bookapp.infrastructure.books.repositories;

import com.example.bookapp.domain.books.Book;
import com.example.bookapp.domain.books.BookTag;
import com.example.bookapp.domain.books.Books;
import com.example.bookapp.domain.tags.Tag;
import com.example.bookapp.infrastructure.authors.repositories.AuthorRepository;
import com.example.bookapp.infrastructure.publishing_houses.repositories.PublishingHouseRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        this.entityManager.persist(book);
        this.entityManager.flush();
    }

    @Override
    public Book getByUuid(UUID uuid) {
        return this.entityManager
                .createQuery("SELECT b FROM Book b WHERE b.uuid = :uuid", Book.class)
                .setParameter("uuid", uuid)
                .getSingleResult();
    }

    @Override
    public void delete(Book book) {
        this.entityManager.remove(book);
    }

    @Override
    public List<Book> filterByTag(Tag tag, String sort, UUID authorUuid, UUID publisherUuid) {
        StringBuilder jpql = new StringBuilder("SELECT b FROM BookTag b " +
                "INNER JOIN b.book.author a " +
                "INNER JOIN b.book.publishingHouse p " +
                "WHERE b.tag = :tag");

        Map<String, Object> params = new HashMap<>();
        params.put("tag", tag);

        if (authorUuid != null) {
            jpql.append(" AND a.uuid = :authorUuid");
            params.put("authorUuid", authorUuid);
        }

        if (publisherUuid != null) {
            jpql.append(" AND p.uuid = :publisherUuid");
            params.put("publisherUuid", publisherUuid);
        }

        if (sort != null) {
            jpql.append(" ORDER BY b.createdAt ").append(sort.equals("DESC") ? "DESC" : "ASC");
        }

        TypedQuery<BookTag> query = entityManager.createQuery(jpql.toString(), BookTag.class);

        for (Map.Entry<String, Object> entry : params.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }

        return query.getResultList()
                .stream()
                .map(BookTag::book)
                .toList();
    }

}
