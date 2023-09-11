package com.example.bookapp.infrastructure.publishing_houses.controllers.requests;

import javax.validation.constraints.NotNull;

public class CreatePublishingHouseRequest {
    @NotNull
    public String name;

}
