package com.example.bookapp.infrastructure.publishing_houses.controllers;

import com.example.bookapp.application.publishing_houses.*;
import com.example.bookapp.infrastructure.publishing_houses.controllers.requests.CreatePublishingHouseRequest;
import com.example.bookapp.infrastructure.publishing_houses.controllers.responses.PublishingHouseResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/publishing_houses")
public class PublishingHouseController {
    private final CreatePublishingHouseService createPublishingHouseService;
    private final UpdatePublishingHouseService updatePublishingHouseService;

    public PublishingHouseController(CreatePublishingHouseService createPublishingHouseService,
            UpdatePublishingHouseService updatePublishingHouseService) {
        this.createPublishingHouseService = createPublishingHouseService;
        this.updatePublishingHouseService = updatePublishingHouseService;
    }

    @PostMapping("/create")
    public PublishingHouseResponse createPublishingHouse(@RequestBody CreatePublishingHouseRequest request) {
        PublishingHouseDTO publishingHouse = createPublishingHouseService.createPublishingHouse(
                new CreatePublishingHouseInput(request.name));
        return PublishingHouseResponse.from(publishingHouse);
    }

    @PutMapping("/update/{uuid}")
    public PublishingHouseResponse updatePublishingHouse(
            @PathVariable UUID uuid,
            @RequestBody CreatePublishingHouseRequest request) {
        PublishingHouseDTO publishingHouseDTO =
                this.updatePublishingHouseService.updatePublishingHouse(
                        new UpdatePublishingHouseInput(uuid, request.name)
                );
        return PublishingHouseResponse.from(publishingHouseDTO);

    }
}
