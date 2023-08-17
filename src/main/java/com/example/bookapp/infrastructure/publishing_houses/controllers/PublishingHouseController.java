package com.example.bookapp.infrastructure.publishing_houses.controllers;

import com.example.bookapp.application.publishing_houses.CreatePublishingHouseInput;
import com.example.bookapp.application.publishing_houses.CreatePublishingHouseService;
import com.example.bookapp.application.publishing_houses.PublishingHouseDTO;
import com.example.bookapp.domain.publishing_houses.PublishingHouse;
import com.example.bookapp.infrastructure.publishing_houses.controllers.requests.PublishingHouseRequest;
import com.example.bookapp.infrastructure.publishing_houses.controllers.responses.PublishingHouseResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publishing_houses")
public class PublishingHouseController {
    private final CreatePublishingHouseService createPublishingHouseService;

    public PublishingHouseController(CreatePublishingHouseService createPublishingHouseService) {
        this.createPublishingHouseService = createPublishingHouseService;
    }

    @PostMapping("/create")
    public PublishingHouseResponse createPublishingHouse(@RequestBody PublishingHouseRequest request) {
        PublishingHouseDTO publishingHouse = createPublishingHouseService.createPublishingHouse(
                new CreatePublishingHouseInput(request.name));
        return PublishingHouseResponse.from(publishingHouse);

    }
}
