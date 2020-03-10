package andersen.course.bookshelf.entity;

import andersen.course.bookshelf.entity.developer.Author;
import andersen.course.bookshelf.entity.developer.Publisher;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Iterator;

@Entity
@Table(name = "books")
@Data
@NoArgsConstructor
public class Book extends Literature {

    @Builder
    public Book(String title, Publisher publisher, Author author) {
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
