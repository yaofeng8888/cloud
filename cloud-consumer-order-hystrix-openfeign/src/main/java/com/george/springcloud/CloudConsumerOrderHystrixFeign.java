package com.george.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * CloudProviderPayment.
 *
 * @author yaofeng 2020-12-14 14:43
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class CloudConsumerOrderHystrixFeign {

	public static void main(String[] args){
		SpringApplication.run(CloudConsumerOrderHystrixFeign.class,args);
	}
}
