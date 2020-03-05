package andersen.course.springdatatask.repo;

import andersen.course.springdatatask.entity.developer.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepo extends CrudRepository<Publisher, Long> {
}
