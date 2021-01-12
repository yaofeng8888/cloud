package com.george.springcloud.controller;

import com.george.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * PaymentController.
 *
 * @author yaofeng 2020-12-14 15:35
 */
@RestController
@Slf4j
public class PaymentController {

	@Autowired
	private PaymentService service;
	@GetMapping("/paymentOK/{id}")
	public String payment_OK(@PathVariable("id") Integer id){
		return service.payment_OK(id);
	}

	@GetMapping("/timeOut/{id}")
	public String timeOut(@PathVariable("id") Integer id){
		return service.timeOut(id);
	}
}
