package com.example.bookapp.infrastructure.books.controllers;


import com.example.bookapp.application.books.*;
import com.example.bookapp.infrastructure.books.controllers.requests.CreateBookRequest;
import com.example.bookapp.infrastructure.books.controllers.requests.UpdateBookRequest;
import com.example.bookapp.infrastructure.books.controllers.responses.BookResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    private final CreateBookService createBookService;
    private final UpdateBookService updatedBookService;


    public BookController(CreateBookService createBookService,
            UpdateBookService updatedBookService) {
        this.createBookService = createBookService;
        this.updatedBookService = updatedBookService;
    }

    @PostMapping("/create")
    public BookResponse createBook(@RequestBody CreateBookRequest request) {
        BookInfo info = new BookInfo(request.title, request.quantity, request.year);
        BookBy bookBy = new BookBy(request.author, request.publishingHouse);
        CreateBookInput dto = new CreateBookInput(info, bookBy);
        BookDTO createdBook = createBookService.createBook(dto);
        return BookResponse.from(createdBook);
    }

    @PutMapping("/update/{uuid}")
    public BookResponse updateBook(@PathVariable UUID uuid, @RequestBody UpdateBookRequest request) {
        BookInfo info = new BookInfo(request.title, request.quantity, request.year);
        BookBy bookBy = new BookBy(request.author, request.publishingHouse);
        UpdateBookInput dto = new UpdateBookInput(uuid,info, bookBy);
        BookDTO updatedBook = this.updatedBookService.updateBook(dto);
        return BookResponse.from(updatedBook);
    }
}
