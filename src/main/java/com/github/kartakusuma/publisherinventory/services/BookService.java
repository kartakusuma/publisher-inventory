package com.github.kartakusuma.publisherinventory.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.github.kartakusuma.publisherinventory.entities.Book;
import com.github.kartakusuma.publisherinventory.repositories.BookRepository;

import jakarta.transaction.Transactional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Transactional
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Transactional
    public Optional<Book> getByIdBook(Long id) {
        return bookRepository.findById(id);
    }

    @Transactional
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book updateBook(Long id, Book updateBook) {
        Optional<Book> existingBook = bookRepository.findById(id);

        if (existingBook.isPresent()) {
            Book book = existingBook.get();
            book.setTitle(updateBook.getTitle());
            book.setDescription(updateBook.getDescription());
            return bookRepository.save(book);
        } else {
            throw new IllegalArgumentException("Book not found with id:" + id);
        }
    }

    @Transactional
    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
