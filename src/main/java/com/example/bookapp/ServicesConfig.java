package com.example.bookapp;

import com.example.bookapp.application.authors.CreateAuthorService;
import com.example.bookapp.application.authors.DeleteAuthorService;
import com.example.bookapp.application.authors.UpdateAuthorService;
import com.example.bookapp.application.books.*;
import com.example.bookapp.application.books.translator.EnglishBookTranslatorService;
import com.example.bookapp.application.books.translator.RussianBookTranslatorService;
import com.example.bookapp.application.publishing_houses.CreatePublishingHouseService;
import com.example.bookapp.application.publishing_houses.DeletePublishingHouseService;
import com.example.bookapp.application.publishing_houses.UpdatePublishingHouseService;
import com.example.bookapp.application.tags.CreateTagService;
import com.example.bookapp.domain.authors.Authors;
import com.example.bookapp.domain.books.BookTags;
import com.example.bookapp.domain.books.Books;
import com.example.bookapp.domain.publishing_houses.PublishingHouses;
import com.example.bookapp.domain.tags.Tags;
import com.example.bookapp.infrastructure.authors.repositories.AuthorRepository;
import com.example.bookapp.infrastructure.books.repositories.BookRepository;
import com.example.bookapp.infrastructure.books.repositories.BookTagRepository;
import com.example.bookapp.infrastructure.publishing_houses.repositories.PublishingHouseRepository;
import com.example.bookapp.infrastructure.tags.repositories.TagRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServicesConfig {

    @Bean
    public Authors authors() {
        return new AuthorRepository();
    }

    @Bean
    public UpdateAuthorService updateAuthorService(Authors authors) {
        return new UpdateAuthorService(authors);
    }

    @Bean
    public CreateAuthorService createAuthorService(Authors authors) {
        return new CreateAuthorService(authors);
    }

    @Bean
    public DeleteAuthorService deleteAuthorService(Authors authors) {
        return new DeleteAuthorService(authors);
    }
    @Bean
    public PublishingHouses publishingHouses() {
        return new PublishingHouseRepository();
    }

    @Bean
    public UpdatePublishingHouseService updatePublishingHouseService(PublishingHouses publishingHouses) {
        return new UpdatePublishingHouseService(publishingHouses);
    }

    @Bean
    public GetBookService getBookService(Books books) {
        return new GetBookService(books);
    }

    @Bean
    public EnglishBookTranslatorService englishBookTranslator() {
        return new EnglishBookTranslatorService();
    }

    @Bean
    public RussianBookTranslatorService russianBookTranslator() {
        return new RussianBookTranslatorService();
    }

    @Bean
    public CreatePublishingHouseService createPublishingHouseService(PublishingHouses publishingHouses) {
        return new CreatePublishingHouseService(publishingHouses);
    }
    @Bean
    public DeletePublishingHouseService deletePublishingHouseService(PublishingHouses publishingHouses) {
        return new DeletePublishingHouseService(publishingHouses);
    }

    @Bean
    public Books books(AuthorRepository authorRepository, PublishingHouseRepository publishingHouseRepository) {
        return new BookRepository(authorRepository, publishingHouseRepository);
    }

    @Bean
    public UpdateBookService updateBookService(
            Authors authors,
            PublishingHouses publishingHouses,
            Books books) {
        return new UpdateBookService(authors, publishingHouses, books);
    }

    @Bean
    public CreateBookService createBookService(
            Authors authors,
            PublishingHouses publishingHouses,
            Books books,
            Tags tags,
            BookTags bookTags
    ) {
        return new CreateBookService(authors, publishingHouses, books, tags, bookTags);
    }

    @Bean
    public DeleteBookService deleteBookService(Books books) {
        return new DeleteBookService(books);
    }


    @Bean
    public Tags tags() {
        return new TagRepository();
    }
    @Bean
    public CreateTagService createTagService(Tags tags) {
        return new CreateTagService(tags);
    }

    @Bean
    public BookTags bookTags() {
        return new BookTagRepository();
    }

    @Bean
    public BookListService bookListService(Tags tags,Books books) {
        return new BookListService(tags,books);
    }
}
