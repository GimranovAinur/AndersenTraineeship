package andersen.course.bookshelf.utils.builders;

import java.util.Date;
import java.util.List;

import andersen.course.bookshelf.entity.Book;
import andersen.course.bookshelf.entity.Literature;
import andersen.course.bookshelf.entity.developers.Author;
import andersen.course.bookshelf.entity.developers.Publisher;

/**
 * Конструктор книг.
 */
public class BookBuilder implements ILiteratureBuilder {

    /** Название */
    private String title;

    /** Авторы */
    private List<Author> authors;

    /** Издатель */
    private Publisher publisher;

    /** Дата издания */
    private Date releaseDate;

    /** Наблюдатель за вызовом конструктора литературы */
    private LiteratureBuildObserver observer = new LiteratureBuildObserver();

    @Override
    public BookBuilder title(String aTitle) {
        title = aTitle;
        return this;
    }

    @Override
    public BookBuilder authors(List<Author> aAuthors) {
        authors = aAuthors;
        return this;
    }

    @Override
    public BookBuilder publisher(Publisher aPublisher) {
        publisher = aPublisher;
        return this;
    }

    @Override
    public BookBuilder releaseDate(Date aReleaseDate) {
        releaseDate = aReleaseDate;
        return this;
    }

    @Override
    public Book build() {
        Book book = new Book(title, authors, publisher, releaseDate);
        notifyObserver(book);
        return book;
    }

    @Override
    public void notifyObserver(Literature aBook) {
        observer.handle(aBook);
    }

}
