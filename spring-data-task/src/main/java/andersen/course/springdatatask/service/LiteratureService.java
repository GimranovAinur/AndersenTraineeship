package andersen.course.springdatatask.service;

import andersen.course.springdatatask.entity.Literature;
import andersen.course.springdatatask.entity.developer.Author;
import andersen.course.springdatatask.entity.developer.Publisher;
import andersen.course.springdatatask.repo.LiteratureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LiteratureService {

    @Autowired
    private LiteratureRepo<Literature> literatureRepo;

    public Literature save(Literature literature, List<Author> authors, Publisher publisher) {
        literature.setAuthors(authors);
        literature.setPublisher(publisher);
        return literatureRepo.save(literature);
    }

    public Literature save(Literature literature) {
        return literatureRepo.save(literature);
    }

    public Optional<Literature> getById(Long id) {
        return literatureRepo.findById(id);
    }

}
