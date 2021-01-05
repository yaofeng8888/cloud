package com.george.springcloud.feign;

import com.george.springcloud.model.ApiResult;
import com.george.springcloud.model.Payment;
import feign.Param;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * OrderService.
 *
 * @author yaofeng 2021/1/5 5:29 下午
 */
@Component
@FeignClient(name = "CLOUD-PAYMENT-SERVICE")
public interface OrderService {

	@RequestMapping("getOne/{id}")
	ApiResult<Payment> getOne(@PathVariable("id") Long id);
}
