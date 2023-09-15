package com.github.kartakusuma.publisherinventory.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.kartakusuma.publisherinventory.entities.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
    
}
