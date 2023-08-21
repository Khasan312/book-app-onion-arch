package com.example.bookapp.domain.publishing_houses;

import com.example.bookapp.domain.books.Book;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "publishing_houses")
public class PublishingHouse {

    @Id
    @GeneratedValue
    @Column(updatable = false)
    private UUID uuid;
    private String name;
    @OneToMany(mappedBy = "publishingHouse", cascade = CascadeType.ALL)
    private List<Book> books;
    private LocalDateTime createdAt;

    public PublishingHouse() {}

    @PrePersist
    private void init() {
        this.createdAt = LocalDateTime.now().withNano(0);
    }
    public PublishingHouse(String name) {
        this.name = name;
    }

    public void updatePublishingHouse(String name) {
        this.name = name;
    }
    public UUID getUuid() {
        return uuid;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }




}
