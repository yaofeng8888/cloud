package com.george.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * CloudProviderPayment.
 *
 * @author yaofeng 2020-12-14 14:43
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//开启服务降级
public class CloudProviderPaymentHystrix {

	public static void main(String[] args){
		SpringApplication.run(CloudProviderPaymentHystrix.class,args);
	}
}
