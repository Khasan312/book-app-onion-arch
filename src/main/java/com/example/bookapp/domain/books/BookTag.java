package com.example.bookapp.domain.books;

import com.example.bookapp.domain.tags.Tag;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "book_tags")
public class BookTag {
    @Id
    @GeneratedValue
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID uuid;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "book_uuid")
    private Book book;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tag_uuid")
    private Tag tag;

    private LocalDateTime createdAt;

    public BookTag() {

    }

    public BookTag(Book book, Tag tag) {
        this.book = book;
        this.tag = tag;
    }

    @PrePersist
    private void init(){
        this.createdAt = LocalDateTime.now().withNano(0);
    }

    public Book book() {
        return book;
    }

}
