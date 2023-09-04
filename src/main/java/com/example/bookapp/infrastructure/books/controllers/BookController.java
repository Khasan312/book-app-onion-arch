package com.example.bookapp.infrastructure.books.controllers;


import com.example.bookapp.application.books.*;
import com.example.bookapp.domain.books.BookTranslator;
import com.example.bookapp.infrastructure.books.controllers.requests.CreateBookRequest;
import com.example.bookapp.infrastructure.books.controllers.requests.UpdateBookRequest;
import com.example.bookapp.infrastructure.books.controllers.responses.BookResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    private final CreateBookService createBookService;
    private final UpdateBookService updatedBookService;
    private final DeleteBookService deleteBookService;
    private final GetBookService getBookService;
    private final BookTranslator englishBookTranslator;
    private final BookTranslator russianBookTranslator;


    public BookController(CreateBookService createBookService,
                          UpdateBookService updatedBookService,
                          DeleteBookService deleteBookService,
                          GetBookService getBookService,
                          BookTranslator englishBookTranslator,
                          BookTranslator russianBookTranslator) {
        this.createBookService = createBookService;
        this.updatedBookService = updatedBookService;
        this.deleteBookService = deleteBookService;
        this.getBookService = getBookService;
        this.englishBookTranslator = englishBookTranslator;
        this.russianBookTranslator = russianBookTranslator;
    }

    @GetMapping("/{uuid}/en")
    public BookResponse getBookToEnglish(@PathVariable UUID uuid) {
        BookDTO bookDTO = this.getBookService.getBook(new GetBookInput(uuid));
        String translatedTitle = englishBookTranslator.translate(bookDTO.getTitle());
        BookDTO dto = new BookDTO(
                bookDTO.getUuid(),
                translatedTitle,
                bookDTO.getQuantity(),
                bookDTO.getYear()
        );
        return BookResponse.from(dto);
    }
    @GetMapping("/{uuid}/ru")
    public BookResponse getBookToRussian(@PathVariable UUID uuid) {
        BookDTO bookDTO = this.getBookService.getBook(new GetBookInput(uuid));
        String translatedTitle = russianBookTranslator.translate(bookDTO.getTitle());
        BookDTO dto = new BookDTO(
                bookDTO.getUuid(),
                translatedTitle,
                bookDTO.getQuantity(),
                bookDTO.getYear()
        );
        return BookResponse.from(dto);
    }

    @PostMapping("/create")
    public BookResponse createBook(@Valid @RequestBody CreateBookRequest request) {
        BookInfo info = new BookInfo(request.title, request.quantity, request.year);
        BookBy bookBy = new BookBy(request.author, request.publishingHouse);
        CreateBookInput dto = new CreateBookInput(info, bookBy);
        BookDTO createdBook = createBookService.createBook(dto);
        return BookResponse.from(createdBook);
    }

    @PutMapping("/{uuid}")
    public BookResponse updateBook(@PathVariable UUID uuid, @Valid @RequestBody UpdateBookRequest request) {
        BookInfo info = new BookInfo(request.title, request.quantity, request.year);
        BookBy bookBy = new BookBy(request.author, request.publishingHouse);
        UpdateBookInput dto = new UpdateBookInput(uuid,info, bookBy);
        BookDTO updatedBook = this.updatedBookService.updateBook(dto);
        return BookResponse.from(updatedBook);
    }

    @DeleteMapping("/delete/{uuid}")
    public String deleteBook(@PathVariable UUID uuid) {
        this.deleteBookService.deleteBook(new DeleteBookInput(uuid));
        return "Book deleted";
    }
}
