package andersen.course.springdatatask.entity;

import andersen.course.springdatatask.entity.developer.Author;
import andersen.course.springdatatask.entity.developer.Publisher;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Iterator;

@Entity
@Table(name = "books")
@Setter
@NoArgsConstructor
public class Book extends Literature{

    @Builder
    public Book(String title,  Publisher publisher, Author author) {
        super(title, publisher, author);
    }

    @Override
    public String getTitlePageInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(getTitle()).append("; ");
        Iterator<Author> authorsIterator = getAuthors().iterator();
        while (authorsIterator.hasNext()) {
            Author author = authorsIterator.next();
            sb.append(author.getFullName());
            if (authorsIterator.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append("\n");
        return sb.toString();
    }

}
