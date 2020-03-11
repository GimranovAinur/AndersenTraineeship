package andersen.course.bookstoreservice.service;

import andersen.course.bookstoreservice.dto.OrderDTO;
import andersen.course.bookstoreservice.dto.OrderDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "order-service")
public interface OrderServiceFeign {

    @PostMapping("/orders/save")
    OrderDTO save(@RequestBody OrderDTO book);

    @GetMapping("/orders")
    List<OrderDTO> getAll();

    @GetMapping("/orders/{id}")
    OrderDTO getById(@PathVariable Long id);

}
