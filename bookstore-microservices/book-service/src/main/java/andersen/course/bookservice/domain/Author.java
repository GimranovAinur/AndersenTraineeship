package andersen.course.bookservice.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "authors")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @Column
    private String surname;

    @ManyToMany
    @JoinTable(name = "author_book_ref", joinColumns =
        @JoinColumn(name = "author_id"), inverseJoinColumns =
        @JoinColumn(name = "book_id"))
    private List<Book> writtenBooks;

}
