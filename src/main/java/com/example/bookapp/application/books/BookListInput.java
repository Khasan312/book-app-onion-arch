package com.example.bookapp.application.books;

import java.util.UUID;

public class BookListInput {
    private final UUID tagUuid;
    private final String sort;
    private final UUID authorUuid;
    private final UUID publisherUuid;
    private final Long userId;

    public BookListInput(UUID tagUuid, String sort, UUID authorUuid, UUID publisherUuid, Long userId) {
        this.tagUuid = tagUuid;
        this.sort = sort;
        this.authorUuid = authorUuid;
        this.publisherUuid = publisherUuid;
        this.userId = userId;
    }

    public UUID getTagUuid() {
        return tagUuid;
    }

    public String getSort() {
        return sort;
    }

    public UUID getAuthorUuid() {
        return authorUuid;
    }

    public UUID getPublisherUuid() {
        return publisherUuid;
    }

    public Long getUserId() {
        return userId;
    }
}
