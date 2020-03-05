package andersen.course.springdatatask.repo;

import andersen.course.springdatatask.entity.Literature;
import org.springframework.data.repository.CrudRepository;

public interface LiteratureRepo<T extends Literature> extends CrudRepository<T, Long> {

}
