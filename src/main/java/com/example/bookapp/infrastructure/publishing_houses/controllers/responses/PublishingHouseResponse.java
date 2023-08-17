package com.example.bookapp.infrastructure.publishing_houses.controllers.responses;

import com.example.bookapp.application.publishing_houses.PublishingHouseDTO;
import com.example.bookapp.domain.publishing_houses.PublishingHouse;

import java.util.UUID;

public class PublishingHouseResponse {
    public UUID uuid;
    public String name;

    public static PublishingHouseResponse from(PublishingHouseDTO publishingHouse) {
        PublishingHouseResponse response = new PublishingHouseResponse();
        response.uuid = publishingHouse.getUuid();
        response.name = publishingHouse.getName();
        return response;
    }
}
