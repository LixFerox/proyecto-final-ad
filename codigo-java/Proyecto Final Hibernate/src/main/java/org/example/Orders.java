package org.example;

import jakarta.persistence.*;

@Entity
@Table(name ="orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private int orderId;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "amount")
    private Double amount;

    public Orders() {
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public Double getAmount() {
        return amount;
    }
}
