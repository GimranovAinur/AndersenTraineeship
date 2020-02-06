package andersen.course.bookshelf.utils.builders;

import java.util.Date;
import java.util.List;

import andersen.course.bookshelf.entity.Literature;
import andersen.course.bookshelf.entity.Magazine;
import andersen.course.bookshelf.entity.developers.Author;
import andersen.course.bookshelf.entity.developers.Publisher;

/**
 * Конструктор журналов.
 */
public class MagazineBuilder implements ILiteratureBuilder {

    /** Название */
    private String title;

    /** Авторы */
    private List<Author> authors;

    /** Издатель */
    private Publisher publisher;

    /** Дата издания */
    private Date releaseDate;

    /** Номер выпуска */
    private int releaseNumber;

    /** Наблюдатель за вызовом конструктора литературы */
    private LiteratureBuildObserver observer = new LiteratureBuildObserver();

    @Override
    public MagazineBuilder title(String aTitle) {
        title = aTitle;
        return this;
    }

    @Override
    public MagazineBuilder authors(List<Author> aAuthors) {
        authors = aAuthors;
        return this;
    }

    @Override
    public MagazineBuilder publisher(Publisher aPublisher) {
        publisher = aPublisher;
        return this;
    }

    @Override
    public MagazineBuilder releaseDate(Date aReleaseDate) {
        releaseDate = aReleaseDate;
        return this;
    }

    public MagazineBuilder releaseNumber(int aReleaseNumber) {
        releaseNumber = aReleaseNumber;
        return this;
    }

    @Override
    public Magazine build() {
        Magazine magazine = new Magazine(title, authors, publisher, releaseDate, releaseNumber);
        notifyObserver(magazine);
        return magazine;
    }

    @Override
    public void notifyObserver(Literature aMagazine) {
        observer.handle(aMagazine);
    }

}
