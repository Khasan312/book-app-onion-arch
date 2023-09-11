package com.example.bookapp.infrastructure.tags.controllers.requests;

import javax.validation.constraints.NotNull;

public class TagRequest {
    @NotNull
    public String name;
}
