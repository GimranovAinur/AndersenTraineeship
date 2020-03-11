package andersen.course.bookstoreservice.service;

import andersen.course.bookstoreservice.dto.BookDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "book-service")
public interface BookServiceFeign {

    @PostMapping("/books/save")
    BookDTO save(@RequestBody BookDTO book);

    @GetMapping("/books")
    List<BookDTO> getAll();

    @GetMapping("/books/{id}")
    BookDTO getById(@PathVariable Long id);
}
