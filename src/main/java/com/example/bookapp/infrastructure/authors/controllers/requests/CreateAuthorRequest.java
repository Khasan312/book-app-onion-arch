package com.example.bookapp.infrastructure.authors.controllers.requests;

import javax.validation.constraints.NotNull;

public class CreateAuthorRequest {
    @NotNull
    public String name;
}
