package com.george.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * CloudProviderPayment.
 *
 * @author yaofeng 2020-12-14 14:43
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerOrderConsul {

	public static void main(String[] args){
		SpringApplication.run(CloudConsumerOrderConsul.class,args);
	}
}
