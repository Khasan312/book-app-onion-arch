package com.example.bookapp.infrastructure.publishing_houses.controllers.responses;

import com.example.bookapp.domain.publishing_houses.PublishingHouse;

import java.util.UUID;

public class PublishingHouseResponse {
    public UUID uuid;
    public String name;

    public static PublishingHouseResponse from(PublishingHouse publishingHouse) {
        PublishingHouseResponse response = new PublishingHouseResponse();
        response.uuid = publishingHouse.getUuid();
        response.name = publishingHouse.getName();
        return response;
    }
}
