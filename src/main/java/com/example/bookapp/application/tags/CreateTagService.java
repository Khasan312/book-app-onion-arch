package com.example.bookapp.application.tags;

import com.example.bookapp.domain.tags.Tag;
import com.example.bookapp.domain.tags.Tags;

public class CreateTagService {
    private final Tags tags;

    public CreateTagService(Tags tags) {
        this.tags = tags;
    }

    public TagResult createTag(CreateTagInput input) {
        String name = input.name();
        Tag tag = new Tag(name);
        this.tags.add(tag);
        return new TagResult(tag.getUuid(), tag.getName());
    }
}
