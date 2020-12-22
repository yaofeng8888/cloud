package com.george.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * CloudProviderPayment.
 *
 * @author yaofeng 2020-12-14 14:43
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class CloudProviderPayment {

	public static void main(String[] args){
		SpringApplication.run(CloudProviderPayment.class,args);
	}
}
