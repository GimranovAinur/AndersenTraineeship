package andersen.course.bookshelf.entity.developers;

import java.util.ArrayList;
import java.util.List;

import andersen.course.bookshelf.entity.Literature;

/**
 * Автор литературы.
 */
public class Author {

    /** Идентификатор */
    private Long id;

    /** Имя */
    private String name;

    /** Фамилия */
    private String surname;

    /** Написанная литература */
    private List<Literature> writtenLiterature = new ArrayList<>();

    public Author(Long aId, String aName, String aSurname) {
        id = aId;
        name = aName;
        surname = aSurname;
    }

    public Author(String aName, String aSurname) {
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
