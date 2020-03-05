package andersen.course.springdatatask.repo;

import andersen.course.springdatatask.entity.developer.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Long> {
}
