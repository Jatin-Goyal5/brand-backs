package com.demo.brandbacks.service;


import com.demo.brandbacks.dto.OrderRequest;
import com.demo.brandbacks.dto.OrderResponse;

public interface OrderService {

	public OrderResponse saveOrder(OrderRequest orderRequest);
}
