package andersen.course.springdatatask.entity.developer;

import andersen.course.springdatatask.entity.Literature;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "publishers")
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Publisher {
    /** Идентификатор */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /** Название */
    @Column
    private String name;

    /** Изданная литература */
    @Singular("releasedLiterature")
    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL)
    private List<Literature> releasedLiterature = new ArrayList<>();

    @Builder
    public Publisher(String name) {
        this.name = name;
    }

    public void addReleasedLiterature(Literature literature) {
        releasedLiterature.add(literature);
    }

}
