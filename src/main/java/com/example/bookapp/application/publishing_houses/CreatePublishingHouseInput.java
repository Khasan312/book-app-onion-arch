package com.example.bookapp.application.publishing_houses;

public class CreatePublishingHouseInput {
    private String name;

    public CreatePublishingHouseInput(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }

}
