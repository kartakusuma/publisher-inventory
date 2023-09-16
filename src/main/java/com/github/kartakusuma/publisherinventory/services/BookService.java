package com.github.kartakusuma.publisherinventory.services;

import java.util.List;

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
    public Book getByIdBook(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Transactional
    public Book createBook(Book book) {
        return bookRepository.save(book);
    }

    @Transactional
    public Book updateBook(Long id, Book updateBook) {
        Book existingBook = bookRepository.findById(id).orElse(null);

        if (existingBook != null) {
            existingBook.setTitle(updateBook.getTitle());
            existingBook.setDescription(updateBook.getDescription());

            return bookRepository.save(existingBook);
        } else {
            throw new IllegalArgumentException("Book not found with id:" + id);
        }
    }

    @Transactional
    public String deleteBook(Long id) {
        bookRepository.deleteById(id);
        return "Book successfully deleted";
    }
}
