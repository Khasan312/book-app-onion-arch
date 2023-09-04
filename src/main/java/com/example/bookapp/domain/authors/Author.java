package com.example.bookapp.domain.authors;

import com.example.bookapp.domain.books.Book;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue
    private UUID uuid;
    @Column(unique = true)
    private String name;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL)
    private List<Book> books;
    private LocalDateTime createdAt;

    public Author() {}
    public Author(String name) {
        this.name = name;
    }

    @PrePersist
    private void init(){
        this.createdAt = LocalDateTime.now().withNano(0);
    }

    public Author(String name, List<Book> books) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.books = books;
    }

    public void updateAuthor(String name) {
        this.name = name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
