package andersen.course.bookshelf.entity;

import andersen.course.bookshelf.entity.developer.Author;
import andersen.course.bookshelf.entity.developer.Publisher;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Singular;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "literature")
@Inheritance(strategy = InheritanceType.JOINED)
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "Literature entity")
public abstract class Literature {

    /** Идентификатор */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty
    private Long id;

    /** Название */
    @Column
    @NotBlank(message = "Введите название")
    @ApiModelProperty(notes = "Literature title")
    private String title;

    /** Авторы */
    @Singular
    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "writtenLiterature", cascade = CascadeType.ALL)
    @ApiModelProperty
    private List<Author> authors = new ArrayList<>();

    /** Издатель */
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "publisher_id")
    @ApiModelProperty
    private Publisher publisher;

    /** Дата издания */
    @Temporal( TemporalType.TIMESTAMP )
    @CreationTimestamp
    @Column(name = "release_date")
    @ApiModelProperty
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
