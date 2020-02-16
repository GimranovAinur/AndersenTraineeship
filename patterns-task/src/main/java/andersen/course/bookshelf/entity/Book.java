package andersen.course.bookshelf.entity;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import andersen.course.bookshelf.entity.developers.Author;
import andersen.course.bookshelf.entity.developers.Publisher;
import andersen.course.bookshelf.utils.builders.BookBuilder;
import andersen.course.bookshelf.utils.builders.ILiteratureBuilder;

/**
 * Книга.
 */
public class Book extends Literature {

    public Book(String aTitle, List<Author> aAuthors, Publisher aPublishers, Date aReleaseDate) {
        super(aTitle, aAuthors, aPublishers, aReleaseDate);
    }

    @Override
    public String getTitlePageInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTitle()).append("; ");
        Iterator<Author> authorsIterator = getAuthors().iterator();
        while (authorsIterator.hasNext()) {
            Author author = authorsIterator.next();
            sb.append(author.getFullName());
            if (authorsIterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("\n");
        return sb.toString();
    }

    /**
     * Возвращает конструктор книг.
     *
     * @return конструктор книг
     */
    public static ILiteratureBuilder builder() {
        return new BookBuilder();
    }

}
