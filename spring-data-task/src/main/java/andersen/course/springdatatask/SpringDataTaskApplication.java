package andersen.course.springdatatask;

import andersen.course.springdatatask.entity.Literature;
import andersen.course.springdatatask.repo.AuthorRepo;
import andersen.course.springdatatask.repo.LiteratureRepo;
import andersen.course.springdatatask.repo.PublisherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataTaskApplication {

    @Autowired
    AuthorRepo authorRepo;

    @Autowired
    PublisherRepo publisherREpo;

    @Autowired
    LiteratureRepo<Literature> literatureRepo;

    public static void main(String[] args) {
        SpringApplication.run(SpringDataTaskApplication.class, args);
    }


}
