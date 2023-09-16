package com.github.kartakusuma.publisherinventory.services;

import java.util.List;

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
    public Author getByIdAuthor(Long id) {
        return authorRepository.findById(id).orElse(null);
    }

    @Transactional
    public Author createAuthor(Author author) {
        return authorRepository.save(author);
    }

    @Transactional
    public Author updateAuthor(Long id, Author updateAuthor) {
        Author existingAuthor = authorRepository.findById(id).orElse(null);

        if (existingAuthor != null) {
            existingAuthor.setName(updateAuthor.getName());
            existingAuthor.setEmail(updateAuthor.getEmail());

            return authorRepository.save(existingAuthor);
        } else {
            throw new IllegalArgumentException("Author not foud with id: " + id);
        }
    }

    @Transactional
    public String deleteAuthor(Long id) {
        authorRepository.deleteById(id);
        return "Author successfully deleted";
    }
}
