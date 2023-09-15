package com.github.kartakusuma.publisherinventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.kartakusuma.publisherinventory.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    
}
