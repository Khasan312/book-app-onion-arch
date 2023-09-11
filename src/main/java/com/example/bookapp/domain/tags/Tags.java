package com.example.bookapp.domain.tags;

import java.util.List;
import java.util.UUID;

public interface Tags {
    void add(Tag tag);
    Long countByName(String name);

    Tag getByUuid(UUID uuid);

    List<Tag> getAll();
}
