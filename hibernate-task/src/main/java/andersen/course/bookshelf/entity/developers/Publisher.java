package andersen.course.bookshelf.entity.developers;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import andersen.course.bookshelf.entity.Literature;

/**
 * Издатель.
 */
@Entity
@Table(name = "publishers")
public class Publisher {

    /** Идентификатор */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Название */
    @Column
    private String name;

    /** Изданная литература */
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<Literature> releasedLiterature = new ArrayList<>();

    public Publisher() {}

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
