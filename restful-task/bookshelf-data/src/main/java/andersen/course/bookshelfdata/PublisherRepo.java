package andersen.course.bookshelfdata;

import andersen.course.bookshelfdomain.developer.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends CrudRepository<Publisher, Long> {
}
