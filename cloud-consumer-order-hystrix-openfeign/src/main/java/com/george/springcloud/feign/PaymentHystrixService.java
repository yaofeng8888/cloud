package com.george.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * OrderService.
 *
 * @author yaofeng 2021/1/5 5:29 下午
 */
@Component
@FeignClient(name = "CLOUD-PAYMENT-HYSTRIX-SERVICE")
public interface PaymentHystrixService {

	@GetMapping("/paymentOK/{id}")
	String getPayment_OK(@PathVariable("id") Long id);

	@GetMapping("/timeOut/{id}")
	String getTimeout(@PathVariable("id") Long id);
}
