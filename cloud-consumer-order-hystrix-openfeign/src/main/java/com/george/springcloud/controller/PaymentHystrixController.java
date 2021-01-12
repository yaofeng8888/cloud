package com.george.springcloud.controller;

import com.george.springcloud.feign.PaymentHystrixService;
import com.george.springcloud.model.ApiResult;
import com.george.springcloud.model.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * OrderController.
 *
 * @author yaofeng 2020-12-14 17:42
 */
@RestController
public class PaymentHystrixController {
	@Autowired
	private PaymentHystrixService orderService;

	@RequestMapping("/getOne/{id}")
	public String getOne(@PathVariable("id") Long id){
		return orderService.getPayment_OK(id);
	}

	@RequestMapping("/payment/timeout/{id}")
	public String timeout(@PathVariable("id") Long id){
		String timeout = orderService.getTimeout(id);
		return timeout;
	}
}
