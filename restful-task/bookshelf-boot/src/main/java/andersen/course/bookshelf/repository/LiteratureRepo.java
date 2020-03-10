package andersen.course.bookshelf.repository;

import andersen.course.bookshelf.entity.Literature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LiteratureRepo<T extends Literature> extends JpaRepository<T, Long> {

}
