package com.demo.brandbacks.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "orders")
public class Order {
    @Id
    private String id;
    private String address;
    private String productId;
    private int quantity;
    private double cashbackAmount;
    private double totalAmount;

}