package andersen.course.springdatatask.entity.developer;

import andersen.course.springdatatask.entity.Literature;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    /**  Написанная литература */
    @Singular("writtenLiterature")
    @ManyToMany
    @JoinTable(name = "author_literature_ref", joinColumns =
            @JoinColumn(name = "author_id"), inverseJoinColumns =
            @JoinColumn(name = "literature_id"))
    private List<Literature> writtenLiterature = new ArrayList<>();

    @Builder
    public Author(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    /**
     * Возвращает полное имя (имя и фамилию).
     *
     * @return полное имя
     */
    public String getFullName() {
        return String.format("%s %s", name, surname);
    }

    public void addWrittenLiterature(Literature literature) {
        writtenLiterature.add(literature);
    }

}
