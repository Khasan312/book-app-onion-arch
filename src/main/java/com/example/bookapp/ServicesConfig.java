package com.example.bookapp;

import com.example.bookapp.application.authors.CreateAuthorService;
import com.example.bookapp.application.books.CreateBookService;
import com.example.bookapp.application.publishing_houses.CreatePublishingHouseService;
import com.example.bookapp.domain.authors.Authors;
import com.example.bookapp.domain.books.Books;
import com.example.bookapp.domain.publishing_houses.PublishingHouses;
import com.example.bookapp.infrastructure.authors.repositories.AuthorRepository;
import com.example.bookapp.infrastructure.books.repositories.BookRepository;
import com.example.bookapp.infrastructure.publishing_houses.repositories.PublishingHouseRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {

    @Bean
    public Authors authors() {
        return new AuthorRepository();
    }

    @Bean
    public CreateAuthorService createAuthorService(Authors authors) {
        return new CreateAuthorService(authors);
    }

    @Bean
    public PublishingHouses publishingHouses() {
        return new PublishingHouseRepository();
    }

    @Bean
    public CreatePublishingHouseService createPublishingHouseService(PublishingHouses publishingHouses) {
        return new CreatePublishingHouseService(publishingHouses);
    }

    @Bean
    public Books books(AuthorRepository authorRepository, PublishingHouseRepository publishingHouseRepository) {
        return new BookRepository(authorRepository, publishingHouseRepository);
    }

    @Bean
    public CreateBookService createBookService(
            Authors authors,
            PublishingHouses publishingHouses,
            Books books
    ) {
        return new CreateBookService(authors, publishingHouses, books);
    }
}
