package com.example.bookapp.application.publishing_houses;

import com.example.bookapp.domain.publishing_houses.PublishingHouse;
import com.example.bookapp.domain.publishing_houses.PublishingHouses;

public class CreatePublishingHouseService {
    private final PublishingHouses publishingHouses;

    public CreatePublishingHouseService(PublishingHouses publishingHouses) {
        this.publishingHouses = publishingHouses;
    }

    public PublishingHouseDTO createPublishingHouse(CreatePublishingHouseInput input) {
        String name = input.name();
        Long publishingHouseCount = this.publishingHouses.countByName(name);
        PublishingHouse publishingHouse;
        if (publishingHouseCount != null && publishingHouseCount > 0) {
            publishingHouse = this.publishingHouses.getByName(name);
        }
        publishingHouse = new PublishingHouse(name);
        this.publishingHouses.add(publishingHouse);

        return PublishingHouseDTO.from(publishingHouse);
    }
}
