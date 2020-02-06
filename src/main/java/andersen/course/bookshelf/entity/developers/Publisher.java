package andersen.course.bookshelf.entity.developers;

import java.util.ArrayList;
import java.util.List;

import andersen.course.bookshelf.entity.Literature;

/**
 * Издатель.
 */
public class Publisher {

    /** Название */
    private String name;

    /** Изданная литература */
    private List<Literature> releasedLiterature = new ArrayList<>();

    public Publisher(String aName) {
        name = aName;
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
