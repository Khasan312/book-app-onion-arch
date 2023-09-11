package com.example.bookapp.application.tags;

public class CreateTagInput {
    private String name;

    public CreateTagInput(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}
