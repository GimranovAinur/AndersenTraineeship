package andersen.course.bookshelf.entity.developers;

import java.util.ArrayList;
import java.util.List;

import andersen.course.bookshelf.entity.Literature;

/**
 * Издатель.
 */
public class Publisher {

    /** Идентификатор */
    private Long id;

    /** Название */
    private String name;

    /** Изданная литература */
    private List<Literature> releasedLiterature = new ArrayList<>();

    public Publisher(Long aId, String aName) {
        id = aId;
        name = aName;
    }

    public Publisher(String aName) {
        name = aName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Literature> getReleasedLiterature() {
        return releasedLiterature;
    }

    public void addReleasedLiterature(Literature aLiterature) {
        releasedLiterature.add(aLiterature);
    }

}
