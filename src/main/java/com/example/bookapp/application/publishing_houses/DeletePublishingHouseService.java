package com.example.bookapp.application.publishing_houses;

import com.example.bookapp.domain.publishing_houses.PublishingHouse;
import com.example.bookapp.domain.publishing_houses.PublishingHouses;

public class DeletePublishingHouseService {
    private final PublishingHouses publishingHouses;

    public DeletePublishingHouseService(PublishingHouses publishingHouses) {
        this.publishingHouses = publishingHouses;
    }

    public void deletePublishingHouse(DeletePublishingHouseInput input) {
        PublishingHouse publishingHouse = this.publishingHouses.getByUuid(input.uuid());
        this.publishingHouses.delete(publishingHouse);
    }
}
