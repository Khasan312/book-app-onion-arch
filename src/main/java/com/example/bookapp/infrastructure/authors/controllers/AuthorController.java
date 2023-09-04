package com.example.bookapp.infrastructure.authors.controllers;

import com.example.bookapp.application.authors.*;
import com.example.bookapp.infrastructure.authors.controllers.requests.CreateAuthorRequest;
import com.example.bookapp.infrastructure.authors.controllers.requests.UpdateAuthorRequest;
import com.example.bookapp.infrastructure.authors.controllers.responses.AuthorResponse;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final CreateAuthorService createAuthorService;
    private final UpdateAuthorService updateAuthorService;

    public AuthorController(CreateAuthorService createAuthorService,
                            UpdateAuthorService updateAuthorService) {
        this.createAuthorService = createAuthorService;
        this.updateAuthorService = updateAuthorService;
    }
    @PostMapping("/create")
    public AuthorResponse createAuthor(@RequestBody CreateAuthorRequest request) {
        AuthorDTO authorDTO = createAuthorService.createAuthor(new CreateAuthorInput(request.name));
        return AuthorResponse.from(authorDTO);
    }

    @PutMapping("/update/{uuid}")
    public AuthorResponse updateAuthor(@PathVariable UUID uuid,
                                       @RequestBody UpdateAuthorRequest request) {
        AuthorDTO authorDTO = this.updateAuthorService.updateAuthor(
                new UpdateAuthorInput(uuid,request.name));
        return AuthorResponse.from(authorDTO);

    }
}
