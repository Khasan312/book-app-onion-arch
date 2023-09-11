package com.example.bookapp.domain.publishing_houses;

import java.util.List;
import java.util.UUID;

public interface PublishingHouses {
    void add(PublishingHouse publishingHouse);
    Long countByName(String name);
    PublishingHouse getByName(String name);
    PublishingHouse getByUuid(UUID uuid);
    void update(PublishingHouse publishingHouse);
    List<PublishingHouse> getAll();
    void delete(PublishingHouse publishingHouse);
}
