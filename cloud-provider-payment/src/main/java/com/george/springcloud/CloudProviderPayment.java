package com.george.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * CloudProviderPayment.
 *
 * @author yaofeng 2020-12-14 14:43
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudProviderPayment {

	public static void main(String[] args){
		SpringApplication.run(CloudProviderPayment.class,args);
	}
}
