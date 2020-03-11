package andersen.course.bookstoreservice.api;

import andersen.course.bookstoreservice.dto.BookDTO;
import andersen.course.bookstoreservice.service.BookServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private BookServiceFeign bookServiceFeign;

    @Autowired
    public BookController(BookServiceFeign bookServiceFeign) {
        this.bookServiceFeign = bookServiceFeign;
    }

    @GetMapping
    public List<BookDTO> getAllBooks() {
        return bookServiceFeign.getAll();
    }

    @GetMapping("/{id}")
    public List<BookDTO> getBookById(@PathVariable Long id) {
        return bookServiceFeign.getAll();
    }

    @PostMapping("/save")
    public BookDTO saveBook(@RequestBody BookDTO book) {
        return bookServiceFeign.save(book);
    }

}
