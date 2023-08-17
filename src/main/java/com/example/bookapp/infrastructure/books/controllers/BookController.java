package com.example.bookapp.infrastructure.books.controllers;


import com.example.bookapp.application.books.BookBy;
import com.example.bookapp.application.books.BookInfo;
import com.example.bookapp.application.books.CreateBookInput;
import com.example.bookapp.application.books.CreateBookService;
import com.example.bookapp.domain.authors.Author;
import com.example.bookapp.domain.books.Book;
import com.example.bookapp.domain.publishing_houses.PublishingHouse;
import com.example.bookapp.infrastructure.books.controllers.requests.CreateBookRequest;
import com.example.bookapp.infrastructure.books.controllers.responses.CreateBookResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    private final CreateBookService createBookService;


    public BookController(CreateBookService createBookService) {
        this.createBookService = createBookService;
    }

    @PostMapping("/create")
    public CreateBookResponse createBook(@RequestBody CreateBookRequest request) {
        BookInfo info = new BookInfo(request.title, request.quantity, request.year);
        BookBy bookBy = new BookBy(request.author, request.publishingHouse);
        CreateBookInput dto = new CreateBookInput(info, bookBy);
        Book book = createBookService.createBook(dto);
        return CreateBookResponse.from(book);
    }
}
