package com.example.bookapp.infrastructure.publishing_houses.controllers.requests;

import javax.validation.constraints.NotNull;
import java.util.UUID;


public class UpdatePublishingHouseRequest {
    @NotNull
    public UUID uuid;
    @NotNull
    public String name;

}
