package andersen.course.orderservice.service;

import andersen.course.orderservice.domain.Order;

import java.util.List;

public interface OrderService {

    Order save(Order order);

    Order findById(Long id);

    List<Order> findAll();
}
