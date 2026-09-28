package com.daniel.backend.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.math.BigDecimal;

@Document(collection = "orders")
public class Order {

    @Id
    private String id;

    private String userId;
    private String name;
    private String productCode;
    private Integer quantity;
    private BigDecimal price;
    private String orderStatus;

    public Order() {
    }

    public Order(
        String userId,
        String name,
        String productCode,
        Integer quantity,
        BigDecimal price,
        String orderStatus
    ) {
        this.userId = userId;
        this.name = name;
        this.productCode = productCode;
        this.quantity = quantity;
        this.price = price;
        this.orderStatus = orderStatus;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuserId() {
        return userId;
    }

    public void setuserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public Integer getQuantity() {
        return quantity;
    }
    
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String  orderStatus) {
        this.orderStatus = orderStatus;
    }
}