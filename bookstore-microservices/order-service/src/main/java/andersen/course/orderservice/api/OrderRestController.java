package andersen.course.orderservice.api;

import andersen.course.orderservice.domain.Order;
import andersen.course.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    private OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.findAll();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable("id") Long id) {
        return orderService.findById(id);
    }

    @PostMapping("/save")
    public Order saveOrder(@RequestBody Order order) {
        return orderService.save(order);
    }

}
