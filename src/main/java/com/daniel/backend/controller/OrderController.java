package com.daniel.backend.controller;

import com.daniel.backend.document.Order;
import com.daniel.backend.service.OrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Pedidos", description = "Administración de pedidos")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @Operation(summary = "Listar pedidos", description = "Obtiene todos los pedidos registrados.")
    public List<Order> getOrders() {
        return orderService.findAll();
    }

    @PostMapping
    @Operation(summary = "Crear un pedido", description = "Registra un nuevo pedido asociado a un usuario.")
    public Order createOrder(
            @RequestBody Order order
    ) {
        return orderService.save(order);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Consultar un pedido", description = "Obtiene un pedido mediante su identificador.")
    public ResponseEntity<Order> getOrderById(@PathVariable String id) {
        Optional<Order> order = orderService.findById(id);

        if (!order.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(order.get());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Actualizar un pedido", description = "Actualiza la información de un pedido existente.")
    public ResponseEntity<Order> updateOrder(
            @PathVariable String id,
            @RequestBody Order order
    ) {

        Optional<Order> updatedOrder =
            orderService.update(id, order);

        if (!updatedOrder.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedOrder.get());
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Eliminar un pedido", description = "Elimina un pedido mediante su identificador.")
    public ResponseEntity<Void> deleteOrder(
            @PathVariable String id
    ) {

        boolean deleted = orderService.deleteById(id);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}
