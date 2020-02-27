package andersen.course.bookshelf.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import andersen.course.bookshelf.entity.developers.Author;
import andersen.course.bookshelf.entity.developers.Publisher;
import andersen.course.bookshelf.utils.adapters.DateAdapter;

/**
 * Журнал.
 */
@Entity
@Table(name = "magazines")
public class Magazine extends Literature {

    /** Номер выпуска */
    @Column(name = "release_number")
    private int releaseNumber;

    public Magazine() {}

    public Magazine(String aTitle, List<Author> aAuthors, Publisher aPublishers, Date aReleaseDate,
            int aReleaseNumber) {
        super(aTitle, aAuthors, aPublishers, aReleaseDate);
        releaseNumber = aReleaseNumber;
    }

    @Override
    public String getTitlePageInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTitle()).append("; ").append(getReleaseNumber()).append("; ")
                .append(DateAdapter.getDateString(getReleaseDate())).append("\n");
        return sb.toString();
    }

    public int getReleaseNumber() {
        return releaseNumber;
    }

}
