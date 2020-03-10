package andersen.course.bookshelf.entity;

import andersen.course.bookshelf.entity.developer.Author;
import andersen.course.bookshelf.entity.developer.Publisher;
import andersen.course.bookshelf.util.DateAdapter;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "magazines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Magazine extends Literature {

    /** Номер выпуска */
    @Column(name = "release_number")
    private int releaseNumber;

    @Builder
    public Magazine(String title, Publisher publisher, Author author, int releaseNumber) {
        super(title, publisher, author);
        this.releaseNumber = releaseNumber;
    }

    @Override
    public String getTitlePageInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTitle()).append("; ").append(releaseNumber).append("; ")
                .append(DateAdapter.getDateString(getReleaseDate())).append("\n");
        return sb.toString();
    }

}
