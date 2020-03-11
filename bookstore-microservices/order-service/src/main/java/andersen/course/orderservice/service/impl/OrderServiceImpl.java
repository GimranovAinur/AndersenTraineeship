package andersen.course.orderservice.service.impl;

import andersen.course.orderservice.domain.Order;
import andersen.course.orderservice.exception.OrderNotFoundException;
import andersen.course.orderservice.repository.OrderRepo;
import andersen.course.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepo orderRepo;

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order save(Order order) {
        return orderRepo.save(order);
    }

    @Override
    public Order findById(Long id) {
        return orderRepo.findById(id).orElseThrow(OrderNotFoundException::new);
    }

    @Override
    public List<Order> findAll() {
        return orderRepo.findAll();
    }
}
