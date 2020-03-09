package andersen.course.bookshelfdata;

import andersen.course.bookshelfdomain.Literature;
import org.springframework.data.repository.CrudRepository;

public interface LiteratureRepo<T extends Literature> extends CrudRepository<T, Long> {

}
