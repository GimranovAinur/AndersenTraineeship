package andersen.course.bookshelf.entity;

import java.util.Date;
import java.util.List;

import andersen.course.bookshelf.entity.developers.Author;
import andersen.course.bookshelf.entity.developers.Publisher;

/**
 * Печатная литература.
 */
public abstract class Literature {

    /** Идентификатор */
    private Long id;

    /** Название */
    private String title;

    /** Авторы */
    private List<Author> authors;

    /** Издатель */
    private Publisher publisher;

    /** Дата издания */
    private Date releaseDate;

    /**
     * Конструктор
     *
     * @param aTitle название
     * @param aAuthors авторы
     * @param aPublishers издатель
     * @param aReleaseDate дата издания
     */
    public Literature(String aTitle, List<Author> aAuthors, Publisher aPublishers,
            Date aReleaseDate) {
        super();
        this.title = aTitle;
        this.authors = aAuthors;
        this.publisher = aPublishers;
        this.releaseDate = aReleaseDate;
    }

    /**
     * Возвращает информацию на титульном листе.
     *
     * @return информация на титульном листе
     */
    public abstract String getTitlePageInfo();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public Publisher getPublishers() {
        return publisher;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

}
