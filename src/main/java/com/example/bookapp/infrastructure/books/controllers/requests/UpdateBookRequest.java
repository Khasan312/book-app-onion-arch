package com.example.bookapp.infrastructure.books.controllers.requests;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class UpdateBookRequest {
    @NotNull
    public UUID uuid;
    @NotNull
    public String title;
    @NotNull
    public int quantity;
    @NotNull
    public int year;
    @NotNull
    public UUID author;
    @NotNull
    public UUID publishingHouse;
}
