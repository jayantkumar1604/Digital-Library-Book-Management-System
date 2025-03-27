package com.example.DigitalLibraryBookManagementSystem.service;

import com.example.DigitalLibraryBookManagementSystem.model.Book;
import com.example.DigitalLibraryBookManagementSystem.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class BookService {
    private static final Logger logger= LoggerFactory.getLogger(BookService.class);

    @Autowired
    private BookRepository repository;

    public Book addBook(Book book) {
        logger.info("Adding book: {}", book);
        validateBookFields(book);
        return repository.save(book);
    }

    public Page<Book> getAllBooks(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Book getBookById(String id) {
        logger.info("Fetching book with ID: {}", id);
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Book not found."));
    }


    public Book getBookByTitle(String title) {
        Optional<Book> optionalBook = repository.findByTitle(title);
        return optionalBook.orElseThrow(() -> new IllegalArgumentException("Book not found with title: " + title));
    }


    public Book updateBook(String id, Book updatedBook) {
        Book book = getBookById(id);
        validateBookFields(updatedBook);
        book.setTitle(updatedBook.getTitle());
        book.setAuthor(updatedBook.getAuthor());
        book.setGenre(updatedBook.getGenre());
        book.setStatus(updatedBook.getStatus());
        return repository.save(book);
    }
    private void validateBookFields(Book book) {
        if (book.getTitle() == null || book.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be empty.");
        }
        if (book.getAuthor() == null || book.getAuthor().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be empty.");
        }
        if (book.getGenre() == null || book.getGenre().isEmpty()) {
            throw new IllegalArgumentException("Genre cannot be empty.");
        }
        if (!"Available".equalsIgnoreCase(book.getStatus()) && !"Checked Out".equalsIgnoreCase(book.getStatus())) {
            throw new IllegalArgumentException("Status must be either 'Available' or 'Checked Out'.");
        }
    }

    public void deleteBook(String id) {
        logger.info("Deleting book with ID: {}", id);
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Book not found.");
        }
        repository.deleteById(id);
    }

}
