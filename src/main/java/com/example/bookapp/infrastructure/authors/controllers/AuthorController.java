package com.example.bookapp.infrastructure.authors.controllers;

import com.example.bookapp.application.authors.*;
import com.example.bookapp.infrastructure.authors.controllers.requests.CreateAuthorRequest;
import com.example.bookapp.infrastructure.authors.controllers.requests.UpdateAuthorRequest;
import com.example.bookapp.infrastructure.authors.controllers.responses.AuthorResponse;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final CreateAuthorService createAuthorService;
    private final UpdateAuthorService updateAuthorService;
    private final DeleteAuthorService deleteAuthorService;

    public AuthorController(CreateAuthorService createAuthorService,
                            UpdateAuthorService updateAuthorService,
                            DeleteAuthorService deleteAuthorService) {
        this.createAuthorService = createAuthorService;
        this.updateAuthorService = updateAuthorService;
        this.deleteAuthorService = deleteAuthorService;
    }
    @PostMapping("/create")
    public AuthorResponse createAuthor(@Valid @RequestBody CreateAuthorRequest request) {
        AuthorDTO authorDTO = createAuthorService.createAuthor(new CreateAuthorInput(request.name));
        return AuthorResponse.from(authorDTO);
    }

    @PutMapping("/{uuid}")
    public AuthorResponse updateAuthor(@PathVariable UUID uuid,
                                       @Valid @RequestBody UpdateAuthorRequest request) {
        AuthorDTO authorDTO = this.updateAuthorService.updateAuthor(
                new UpdateAuthorInput(uuid,request.name));
        return AuthorResponse.from(authorDTO);
    }

    @DeleteMapping("/{uuid}")
    public String deleteAuthor(@PathVariable UUID uuid) {
        this.deleteAuthorService.deleteAuthor(new DeleteAuthorInput(uuid));
        return "Author deleted";
    }
}
