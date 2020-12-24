package com.george.springcloud;

import com.george.myrule.MySelfRule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * CloudProviderPayment.
 *
 * @author yaofeng 2020-12-14 14:43
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = MySelfRule.class)
public class CloudConsumerOrder {

	public static void main(String[] args){
		SpringApplication.run(CloudConsumerOrder.class,args);
	}
}
