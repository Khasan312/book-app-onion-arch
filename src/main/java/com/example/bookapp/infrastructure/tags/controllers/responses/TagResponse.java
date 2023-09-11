package com.example.bookapp.infrastructure.tags.controllers.responses;

import com.example.bookapp.application.tags.TagResult;
import com.example.bookapp.domain.tags.Tag;

import java.util.UUID;

public class TagResponse {
    public UUID uuid;
    public String name;

    public static TagResponse fromTagResult(TagResult tagResult) {
        TagResponse response = new TagResponse();
        response.name = tagResult.name();
        response.uuid = tagResult.uuid();
        return response;
    }
}
