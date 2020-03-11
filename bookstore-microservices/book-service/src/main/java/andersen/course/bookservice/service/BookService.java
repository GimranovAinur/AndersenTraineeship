package andersen.course.bookservice.service;

import andersen.course.bookservice.domain.Book;

import java.util.List;

public interface BookService {

    Book save(Book order);

    Book findById(Long id);

    List<Book> findAll();
}
