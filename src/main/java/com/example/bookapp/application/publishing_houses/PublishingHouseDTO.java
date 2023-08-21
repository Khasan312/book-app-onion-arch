package com.example.bookapp.application.publishing_houses;

import com.example.bookapp.domain.publishing_houses.PublishingHouse;

import java.util.UUID;

public class PublishingHouseDTO {
    private UUID uuid;
    private String name;

    public PublishingHouseDTO(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public static PublishingHouseDTO from(PublishingHouse publishingHouse) {
        return new PublishingHouseDTO(
                publishingHouse.getUuid(),
                publishingHouse.getName()
        );
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getName() {
        return name;
    }
}
