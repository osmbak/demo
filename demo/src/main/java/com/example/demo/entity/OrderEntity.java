package com.example.demo.entity;


import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import com.example.demo.common.enums.OrderEnums;

@Entity
@Table(name = "orders")
//@SequenceGenerator(name = "order_seq", sequenceName = "order_seq", allocationSize = 1)
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "orderEntity")
    private Set<ItemEntity> itemEntities;
    @Enumerated(EnumType.STRING)
    private OrderEnums status;
    private Long customerId;
    private Double cost;


    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Set<ItemEntity> getItemEntities() {
        if (itemEntities == null || itemEntities.size() == 0) {
            itemEntities = new HashSet<>();
        }
        return itemEntities;
    }

    public void setItemEntities(Set<ItemEntity> itemEntities) {
        this.itemEntities = itemEntities;
    }

    public OrderEnums getStatus() {
        return status;
    }

    public void setStatus(OrderEnums status) {
        this.status = status;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }


}
