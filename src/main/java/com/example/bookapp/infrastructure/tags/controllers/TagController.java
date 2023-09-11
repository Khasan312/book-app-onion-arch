package com.example.bookapp.infrastructure.tags.controllers;

import com.example.bookapp.application.tags.CreateTagInput;
import com.example.bookapp.application.tags.CreateTagService;
import com.example.bookapp.application.tags.TagResult;
import com.example.bookapp.infrastructure.tags.controllers.requests.TagRequest;
import com.example.bookapp.infrastructure.tags.controllers.responses.TagResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/tags")
public class TagController {

    private final CreateTagService createTagService;

    public TagController(CreateTagService createTagService) {
        this.createTagService = createTagService;
    }

    @PostMapping("/create")
    public TagResponse createTag(@Valid @RequestBody TagRequest request) {
        TagResult result = this.createTagService.createTag(new CreateTagInput(request.name));
        return  TagResponse.fromTagResult(result);
    }
}
