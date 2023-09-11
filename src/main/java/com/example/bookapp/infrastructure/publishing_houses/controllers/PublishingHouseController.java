package com.example.bookapp.infrastructure.publishing_houses.controllers;

import com.example.bookapp.application.publishing_houses.*;
import com.example.bookapp.infrastructure.publishing_houses.controllers.requests.CreatePublishingHouseRequest;
import com.example.bookapp.infrastructure.publishing_houses.controllers.requests.UpdatePublishingHouseRequest;
import com.example.bookapp.infrastructure.publishing_houses.controllers.responses.PublishingHouseResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/publishing_houses")
public class PublishingHouseController {
    private final CreatePublishingHouseService createPublishingHouseService;
    private final UpdatePublishingHouseService updatePublishingHouseService;
    private final DeletePublishingHouseService deletePublishingHouseService;

    public PublishingHouseController(CreatePublishingHouseService createPublishingHouseService,
                                     UpdatePublishingHouseService updatePublishingHouseService,
                                     DeletePublishingHouseService deletePublishingHouseService) {
        this.createPublishingHouseService = createPublishingHouseService;
        this.updatePublishingHouseService = updatePublishingHouseService;
        this.deletePublishingHouseService = deletePublishingHouseService;
    }

    @PostMapping("/create")
    public PublishingHouseResponse createPublishingHouse(@RequestBody CreatePublishingHouseRequest request) {
        PublishingHouseDTO publishingHouse = createPublishingHouseService.createPublishingHouse(
                new CreatePublishingHouseInput(request.name));
        return PublishingHouseResponse.from(publishingHouse);
    }

    @PutMapping("/{uuid}")
    public PublishingHouseResponse updatePublishingHouse(@PathVariable UUID uuid,
                                                         @Valid @RequestBody UpdatePublishingHouseRequest request) {
        PublishingHouseDTO publishingHouseDTO =
                this.updatePublishingHouseService.updatePublishingHouse(
                new UpdatePublishingHouseInput(uuid,request.name));
        return PublishingHouseResponse.from(publishingHouseDTO);
    }

    @DeleteMapping("/{uuid}")
    public String deletePublishingHouse(@PathVariable UUID uuid) {
        this.deletePublishingHouseService.deletePublishingHouse(
                new DeletePublishingHouseInput(uuid));
        return "Publishing house deleted";
    }
}
