package com.george.springcloud.controller;

import com.george.springcloud.feign.PaymentHystrixService;
import com.george.springcloud.model.ApiResult;
import com.george.springcloud.model.Payment;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import java.util.concurrent.TimeUnit;

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
@DefaultProperties(defaultFallback = "commonFallback")//通用的服务降级方法
public class PaymentHystrixController {
	@Autowired
	private PaymentHystrixService orderService;

	@RequestMapping("/getOne/{id}")
	@HystrixCommand
	public String getOne(@PathVariable("id") Long id){
		int i = 10/0;
		return orderService.getPayment_OK(id);
	}

	@RequestMapping("/getFeign/{id}")
	public String getFeign(@PathVariable("id") Long id){
		return orderService.getTimeout(id);
	}

	@RequestMapping("/payment/timeout/{id}")
	@HystrixCommand(fallbackMethod = "timeOutFallback",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
	})
	public String timeout(@PathVariable("id") Long id){
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		}catch (Exception e){
//			e.printStackTrace();
//		}
		String timeout = orderService.getTimeout(id);
		return timeout;
	}
	public String timeOutFallback(@PathVariable("id") Long id){
		return "Hystrix 服务正忙，请稍后再试！编号="+id;
	}

	public String commonFallback(){
		return "通用服务降级，服务正忙!";
	}
}
