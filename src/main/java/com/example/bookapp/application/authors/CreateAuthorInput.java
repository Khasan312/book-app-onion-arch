package com.example.bookapp.application.authors;

public class CreateAuthorInput {
    private String name;

    public CreateAuthorInput(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}
