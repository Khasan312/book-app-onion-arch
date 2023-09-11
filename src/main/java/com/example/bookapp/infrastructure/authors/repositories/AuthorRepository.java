package com.example.bookapp.infrastructure.authors.repositories;

import com.example.bookapp.domain.authors.Author;
import com.example.bookapp.domain.authors.Authors;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class AuthorRepository implements Authors {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void add(Author author) {
        this.entityManager.persist(author);
        this.entityManager.flush();
    }

    @Override
    public Long countByName(String name) {
        return null;
    }

    @Override
    public Author getByUuid(UUID uuid) {
        return this.entityManager.createQuery(
                "SELECT a FROM Author a WHERE a.uuid = :uuid", Author.class
        ).setParameter("uuid", uuid).getSingleResult();
    }

    @Override
    public Author getByName(String name) {
        return this.entityManager.createQuery(
                "SELECT a FROM Author a WHERE a.name = :name", Author.class
        ).setParameter("name", name).getSingleResult();
    }

    @Override
    public void update(Author author) {
        this.entityManager.persist(author);
        this.entityManager.flush();
    }

    @Override
    public List<Author> getAll() {
        return null;
    }

    @Override
    public void delete(Author author) {
        this.entityManager.remove(author);
    }
}
