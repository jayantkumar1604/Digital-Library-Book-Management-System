package com.example.DigitalLibraryBookManagementSystem.repository;

import com.example.DigitalLibraryBookManagementSystem.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository <Book, String> {
    Optional<Book> findByTitle(String title);
    Page<Book> findAll(Pageable pageable);
}
