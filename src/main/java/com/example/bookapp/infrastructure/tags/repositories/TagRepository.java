package com.example.bookapp.infrastructure.tags.repositories;

import com.example.bookapp.domain.tags.Tag;
import com.example.bookapp.domain.tags.Tags;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class TagRepository implements Tags {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void add(Tag tag) {
        this.entityManager.persist(tag);
        this.entityManager.flush();
    }

    @Override
    public Long countByName(String name) {
        return null;
    }

    @Override
    public Tag getByUuid(UUID uuid) {
        return this.entityManager.createQuery(
                "SELECT t FROM Tag t WHERE t.uuid = :uuid", Tag.class
        ).setParameter("uuid", uuid).getSingleResult();
    }

    @Override
    public List<Tag> getAll() {
        return null;
    }
}
