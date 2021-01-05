package com.george.springcloud.controller;

import com.george.springcloud.feign.OrderService;
import com.george.springcloud.model.ApiResult;
import com.george.springcloud.model.Payment;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * OrderController.
 *
 * @author yaofeng 2020-12-14 17:42
 */
@RestController
public class OrderController {
	@Autowired
	private OrderService orderService;

	@RequestMapping("getOne/{id}")
	public ApiResult<Payment> getOne(@PathVariable("id") Long id){
		return orderService.getOne(id);
	}
}
