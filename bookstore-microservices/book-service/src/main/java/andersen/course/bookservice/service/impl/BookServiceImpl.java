package andersen.course.bookservice.service.impl;

import andersen.course.bookservice.domain.Book;
import andersen.course.bookservice.exception.BookNotFoundException;
import andersen.course.bookservice.repository.BookRepo;
import andersen.course.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    private BookRepo bookRepo;

    @Autowired
    public BookServiceImpl(BookRepo bookRepo) {
        this.bookRepo = bookRepo;
    }

    @Override
    public Book save(Book book) {
        return bookRepo.save(book);
    }

    @Override
    public Book findById(Long id) {
        return bookRepo.findById(id).orElseThrow(BookNotFoundException::new);
    }

    @Override
    public List<Book> findAll() {
        return bookRepo.findAll();
    }
}
