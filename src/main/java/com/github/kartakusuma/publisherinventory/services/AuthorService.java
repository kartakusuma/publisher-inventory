package com.github.kartakusuma.publisherinventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.kartakusuma.publisherinventory.entities.Author;
import com.github.kartakusuma.publisherinventory.repositories.AuthorRepository;

import jakarta.transaction.Transactional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;
    
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Transactional
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @Transactional
    public Optional<Author> getAuthorById(Long id) {
        return authorRepository.findById(id);
    }

    @Transactional
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public Author updateAuthor(Long id, Author updateAuthor) {
        Optional<Author> existingAuthor = authorRepository.findById(id);

        if (existingAuthor.isPresent()) {
            Author author = existingAuthor.get();
            author.setName(updateAuthor.getName());
            author.setEmail(updateAuthor.getEmail());

            return authorRepository.save(author);
        } else {
            throw new IllegalArgumentException("Author not foud with id: " + id);
        }
    }

    @Transactional
    public void deleteAuthor(Long id) {
        authorRepository.deleteById(id);
    }
}
