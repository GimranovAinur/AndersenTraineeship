package andersen.course.bookshelf.controller;

import andersen.course.bookshelf.entity.Book;
import andersen.course.bookshelf.repository.LiteratureRepo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/book", produces = MediaType.APPLICATION_JSON_VALUE)
public class BookRestController extends LiteratureRestController<Book>{

    public BookRestController(LiteratureRepo<Book> literatureRepo) {
        super(literatureRepo);
    }

}
