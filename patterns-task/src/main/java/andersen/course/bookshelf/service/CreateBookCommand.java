package andersen.course.bookshelf.service;

import java.util.Scanner;

import andersen.course.bookshelf.entity.Book;
import andersen.course.bookshelf.utils.builders.BookBuilder;

public class CreateBookCommand extends AbstractCreateLiteratureCommand {

    @Override
    public Book execute(Scanner aScanner) {
        setScanner(aScanner);
        BookBuilder builder = new BookBuilder();
        Book book = builder.title(getTitleInput()).authors(getAuthorsInput())
                .publisher(getPublisherInput()).releaseDate(getDateInput()).build();
        getScanner().close();
        return book;
    }

}
