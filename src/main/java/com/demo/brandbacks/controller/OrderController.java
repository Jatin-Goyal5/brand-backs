package com.demo.brandbacks.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.brandbacks.constants.Constants;
import com.demo.brandbacks.dto.GenericResponseBuilder;
import com.demo.brandbacks.dto.OrderRequest;
import com.demo.brandbacks.dto.OrderResponse;
import com.demo.brandbacks.service.OrderService;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

	@Autowired
	private OrderService orderService; // Service to handle business logic

	// Endpoint to place a new order
	@PostMapping("/place")
	public ResponseEntity<?> placeOrder(@Validated @RequestBody OrderRequest orderRequest) {
		try {
			OrderResponse orderResponse = orderService.saveOrder(orderRequest);


			return new ResponseEntity<>(GenericResponseBuilder.builder().message("Order placed successfully").data(orderResponse)
					.status(Constants.Status.SUCCESS.name()).build(), HttpStatus.OK);
		} catch (Exception exp) {
			return new ResponseEntity<>(GenericResponseBuilder.builder().message(exp.getMessage())
					.status(Constants.Status.FAILURE.name()).build(), HttpStatus.EXPECTATION_FAILED);
		}
	}

}
