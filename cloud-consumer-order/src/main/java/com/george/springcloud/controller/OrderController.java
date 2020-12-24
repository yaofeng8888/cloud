package com.george.springcloud.controller;

import com.george.springcloud.model.ApiResult;
import com.george.springcloud.model.Payment;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * OrderController.
 *
 * @author yaofeng 2020-12-14 17:42
 */
@RestController
@Slf4j
public class OrderController {
	public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

	@Resource
	private RestTemplate restTemplate;

	@GetMapping("/getOne/{id}")
	public ApiResult<Payment> getPayment(@PathVariable("id") Long id) {
		System.out.println("---------订单系统-----------");
		ApiResult forObject = restTemplate.getForObject(PAYMENT_URL + "/getOne/" + id, ApiResult.class);
		return forObject;
	}

	@GetMapping("/getOne/getEntity/{id}")
	public ApiResult<Payment> getEntityPayment(@PathVariable("id") Long id) {
		System.out.println("---------订单系统-----------");
		ResponseEntity<ApiResult> forEntity = restTemplate.getForEntity(PAYMENT_URL + "/getOne/" + id, ApiResult.class);
		if (forEntity.getStatusCode().is2xxSuccessful()){
			return forEntity.getBody();
		}else {
			return null;
		}
	}
}
