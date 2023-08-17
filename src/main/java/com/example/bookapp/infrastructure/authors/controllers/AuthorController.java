package com.example.bookapp.infrastructure.authors.controllers;

import com.example.bookapp.application.authors.AuthorDTO;
import com.example.bookapp.application.authors.CreateAuthorInput;
import com.example.bookapp.application.authors.CreateAuthorService;
import com.example.bookapp.infrastructure.authors.controllers.requests.AuthorRequest;
import com.example.bookapp.infrastructure.authors.controllers.responses.AuthorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    private final CreateAuthorService createAuthorService;

    public AuthorController(CreateAuthorService createAuthorService) {
        this.createAuthorService = createAuthorService;
    }
    @PostMapping("/create")
    public AuthorResponse createAuthor(@RequestBody AuthorRequest request) {
        AuthorDTO authorDTO = createAuthorService.createAuthor(new CreateAuthorInput(request.name));
        return AuthorResponse.from(authorDTO);
    }
}
