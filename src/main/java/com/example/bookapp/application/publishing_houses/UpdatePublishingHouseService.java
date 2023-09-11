package com.example.bookapp.application.publishing_houses;

import com.example.bookapp.domain.publishing_houses.PublishingHouse;
import com.example.bookapp.domain.publishing_houses.PublishingHouses;

public class UpdatePublishingHouseService {
    private final PublishingHouses publishingHouses;

    public UpdatePublishingHouseService(PublishingHouses publishingHouses) {
        this.publishingHouses = publishingHouses;
    }

    public PublishingHouseDTO updatePublishingHouse(UpdatePublishingHouseInput input) {
        String name = input.name();
        PublishingHouse publishingHouse = this.publishingHouses.getByUuid(input.uuid());
        publishingHouse.updatePublishingHouse(name);
        this.publishingHouses.update(publishingHouse);

        return PublishingHouseDTO.from(publishingHouse);
    }
}
