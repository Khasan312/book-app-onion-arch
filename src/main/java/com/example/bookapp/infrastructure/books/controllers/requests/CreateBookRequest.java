package com.example.bookapp.infrastructure.books.controllers.requests;

import javax.validation.constraints.NotNull;
import java.util.UUID;

public class CreateBookRequest {
    @NotNull
    public String title;
    @NotNull
    public UUID author;
    @NotNull
    public UUID publishingHouse;
    @NotNull
    public int quantity;
    @NotNull
    public int year;
}
