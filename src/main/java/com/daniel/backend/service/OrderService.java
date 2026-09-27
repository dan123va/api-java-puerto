package com.daniel.backend.service;

import java.util.Optional;
import com.daniel.backend.document.Order;
import com.daniel.backend.repository.OrderRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(
            OrderRepository orderRepository
    ) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order save(Order order) {
        return orderRepository.save(order);
    }

    public Optional<Order> findById(String id) {
        return orderRepository.findById(id);
    }

    public Optional<Order> update(
        String id,
        Order order
    ) {

        Optional<Order> existingOrder = orderRepository.findById(id);

        if (!existingOrder.isPresent()) {
            return Optional.empty();
        }

        Order orderToUpdate = existingOrder.get();

        orderToUpdate.setProductCode(order.getProductCode());
        orderToUpdate.setQuantity(order.getQuantity());
        orderToUpdate.setPrice(order.getPrice());
        orderToUpdate.setOrderStatus(order.getOrderStatus());

        Order updatedOrder = orderRepository.save(orderToUpdate);

        return Optional.of(updatedOrder);
    }

    public boolean deleteById(String id) {
        if (!orderRepository.existsById(id)) {
            return false;
        }

        orderRepository.deleteById(id);

        return true;
    }
}