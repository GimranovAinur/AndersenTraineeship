package andersen.course.bookshelf.entity.developers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import andersen.course.bookshelf.entity.Literature;

/**
 * Автор литературы.
 */
@Entity
@Table(name = "authors")
public class Author {

    /** Идентификатор */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Имя */
    @Column
    private String name;

    /** Фамилия */
    @Column
    private String surname;

    /** Написанная литература */
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "author_literature_ref", joinColumns = {
            @JoinColumn(name = "author_id")}, inverseJoinColumns = {
                    @JoinColumn(name = "literature_id")})
    private List<Literature> writtenLiterature = new ArrayList<>();

    public Author() {}

    public Author(String aName, String aSurname) {
        name = aName;
        surname = aSurname;
    }

    public Author(Long aId, String aName, String aSurname) {
        id = aId;
        name = aName;
        surname = aSurname;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public List<Literature> getWrittenLiterature() {
        return writtenLiterature;
    }

    public void addWrittenLiterature(Literature aLiterature) {
        writtenLiterature.add(aLiterature);
    }

    /**
     * Возвращает полное имя (имя и фамилию).
     *
     * @return полное имя
     */
    public String getFullName() {
        return String.format("%s %s", name, surname);
    }

}
