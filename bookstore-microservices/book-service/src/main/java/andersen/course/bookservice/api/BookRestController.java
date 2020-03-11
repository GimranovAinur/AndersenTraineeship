package andersen.course.bookservice.api;

import andersen.course.bookservice.domain.Book;
import andersen.course.bookservice.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookRestController {

    private BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllOrders() {
        return bookService.findAll();
    }

    @GetMapping("/{id}")
    public Book getOrder(@PathVariable("id") Long id) {
        return bookService.findById(id);
    }

    @PostMapping("/save")
    public Book saveOrder(@RequestBody Book book) {
        return bookService.save(book);
    }

}
