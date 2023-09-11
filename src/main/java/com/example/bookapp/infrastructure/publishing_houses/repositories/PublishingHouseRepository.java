package com.example.bookapp.infrastructure.publishing_houses.repositories;

import com.example.bookapp.domain.publishing_houses.PublishingHouse;
import com.example.bookapp.domain.publishing_houses.PublishingHouses;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Transactional
public class PublishingHouseRepository implements PublishingHouses {

    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public void add(PublishingHouse publishingHouse) {
        this.entityManager.persist(publishingHouse);
        this.entityManager.flush();
    }

    @Override
    public Long countByName(String name) {
        return null;
    }

    @Override
    public PublishingHouse getByName(String name) {
        return null;
    }

    @Override
    public PublishingHouse getByUuid(UUID uuid) {
        return this.entityManager.createQuery(
                "SELECT p FROM PublishingHouse p WHERE p.uuid = :uuid", PublishingHouse.class
        ).setParameter("uuid", uuid).getSingleResult();
    }

    @Override
    public void update(PublishingHouse publishingHouse) {

    }

    @Override
    public List<PublishingHouse> getAll() {
        return null;
    }

    @Override
    public void delete(PublishingHouse publishingHouse) {
        this.entityManager.remove(publishingHouse);
    }
}
