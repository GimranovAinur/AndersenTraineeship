package andersen.course.bookshelfdomain;

import andersen.course.bookshelfdomain.developer.Author;
import andersen.course.bookshelfdomain.developer.Publisher;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "literature")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class Literature {

    /** Идентификатор */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Название */
    @Column
    private String title;

    /** Авторы */
    @Singular
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "writtenLiterature", cascade = CascadeType.ALL)
    private List<Author> authors = new ArrayList<>();

    /** Издатель */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    /** Дата издания */
    @Temporal( TemporalType.TIMESTAMP )
    @CreationTimestamp
    @Column(name = "release_date")
    private Date releaseDate;

    public Literature(String title, Publisher publisher, Author author) {
        this.title = title;
        this.publisher = publisher;
        addAuthor(author);
    }

    /**
     * Возвращает информацию на титульном листе.
     *
     * @return информация на титульном листе
     */
    public abstract String getTitlePageInfo();

    public void addAuthor(Author author) {
        authors.add(author);
        author.addWrittenLiterature(this);
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
        publisher.addReleasedLiterature(this);
    }

}
