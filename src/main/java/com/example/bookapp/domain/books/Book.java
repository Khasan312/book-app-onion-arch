package com.example.bookapp.domain.books;

import com.example.bookapp.domain.authors.Author;
import com.example.bookapp.domain.publishing_houses.PublishingHouse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue
    private UUID uuid;
    private String title;
    private int quantity;
    private int year;
    private LocalDateTime createdAt;
    @ManyToOne
    private Author author;
    @ManyToOne
    @JoinColumn(name = "publishing_house_id")
    private PublishingHouse publishingHouse;

    public Book() {}

    public Book(
                String title,
                int quantity,
                int year,
                Author author, PublishingHouse publishingHouse) {
        this.title = title;
        this.quantity = quantity;
        this.year = year;
        this.author = author;
        this.publishingHouse = publishingHouse;
    }

    @PrePersist
    private void init(){
        this.createdAt = LocalDateTime.now().withNano(0);
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public void updateBook(String title, int quantity, int year) {
        this.title = title;
        this.quantity = quantity;
        this.year = year;
    }

    public void updateBy(Author author, PublishingHouse publishingHouse) {
        this.author = author;
        this.publishingHouse = publishingHouse;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public PublishingHouse getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(PublishingHouse publishingHouse) {
        this.publishingHouse = publishingHouse;
    }
}
