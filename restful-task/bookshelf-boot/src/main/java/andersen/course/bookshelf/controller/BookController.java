package andersen.course.bookshelf.controller;

import andersen.course.bookshelf.entity.Book;
import andersen.course.bookshelf.repository.LiteratureRepo;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = "/book")
public class BookController extends LiteratureController<Book>{

    public BookController(LiteratureRepo<Book> literatureRepo) {
        super(literatureRepo);
    }
}
