package com.example.bookapp.application.publishing_houses;

import java.util.UUID;

public class DeletePublishingHouseInput {
    private UUID uuid;

    public DeletePublishingHouseInput(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }
}
