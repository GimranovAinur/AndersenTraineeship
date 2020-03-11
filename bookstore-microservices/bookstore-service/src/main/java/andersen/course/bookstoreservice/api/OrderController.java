package andersen.course.bookstoreservice.api;

import andersen.course.bookstoreservice.dto.BookDTO;
import andersen.course.bookstoreservice.dto.OrderDTO;
import andersen.course.bookstoreservice.service.BookServiceFeign;
import andersen.course.bookstoreservice.service.OrderServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("orders")
public class OrderController {

    private OrderServiceFeign orderServiceFeign;

    @Autowired
    public OrderController(OrderServiceFeign orderServiceFeign) {
        this.orderServiceFeign = orderServiceFeign;
    }

    @GetMapping
    public List<OrderDTO> getAllBooks() {
        return orderServiceFeign.getAll();
    }

    @GetMapping("/{id}")
    public List<OrderDTO> getBookById(@PathVariable Long id) {
        return orderServiceFeign.getAll();
    }

    @PostMapping("/save")
    public OrderDTO saveBook(@RequestBody OrderDTO book) {
        return orderServiceFeign.save(book);
    }

}
