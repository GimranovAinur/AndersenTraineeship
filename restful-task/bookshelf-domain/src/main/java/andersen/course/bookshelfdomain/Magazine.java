package andersen.course.bookshelfdomain;

import andersen.course.bookshelfdomain.developer.Author;
import andersen.course.bookshelfdomain.developer.Publisher;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "magazines")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Magazine extends Literature{

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
