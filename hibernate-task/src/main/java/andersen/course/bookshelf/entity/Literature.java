package andersen.course.bookshelf.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import andersen.course.bookshelf.entity.developers.Author;
import andersen.course.bookshelf.entity.developers.Publisher;

/**
 * Печатная литература.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Literature {

    /** Идентификатор */
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    /** Название */
    @Column
    private String title;

    /** Авторы */
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "writtenLiterature")
    private List<Author> authors;

    /** Издатель */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    /** Дата издания */
    @Column(name = "release_date")
    private Date releaseDate;

    public Literature() {}

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

    public Publisher getPublisher() {
        return publisher;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

}
