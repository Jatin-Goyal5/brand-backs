package com.demo.brandbacks.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.brandbacks.dto.OrderRequest;
import com.demo.brandbacks.dto.OrderResponse;
import com.demo.brandbacks.model.Order;
import com.demo.brandbacks.repository.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepository;
	
	@Override
	public OrderResponse saveOrder(OrderRequest orderRequest) {
		try {
			  Order order = new Order();
		        order.setAddress(orderRequest.getAddress());
		        order.setProductId(orderRequest.getProductId());
		        order.setQuantity(orderRequest.getQuantity());
		        order.setCashbackAmount(orderRequest.getCashbackAmount());
		        order.setTotalAmount(calculateTotal(orderRequest));

		        Order savedOrder = orderRepository.save(order);

		        OrderResponse response = new OrderResponse();
		        response.setOrderId(savedOrder.getId());
		        response.setStatus("SUCCESS");
		        response.setTotalAmount(savedOrder.getTotalAmount());

		        return response;
		}catch(Exception exp) {
			exp.printStackTrace();
			return null;
		}
	}
	
	
	  private double calculateTotal(OrderRequest orderRequest) {
	        // Add logic to calculate total amount based on quantity and product price
	        // For example:
	        return orderRequest.getQuantity() *  orderRequest.getCashbackAmount(); // Assuming price per item is 100
	    }
	
}
