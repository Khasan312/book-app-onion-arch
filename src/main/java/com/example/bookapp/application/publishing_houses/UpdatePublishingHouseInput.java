package com.example.bookapp.application.publishing_houses;

import java.util.UUID;

public class UpdatePublishingHouseInput {
    private UUID uuid;
    private String name;

    public UpdatePublishingHouseInput(UUID uuid, String name) {
        this.uuid = uuid;
        this.name = name;
    }

    public UUID uuid() {
        return uuid;
    }

    public String name() {
        return name;
    }
}
