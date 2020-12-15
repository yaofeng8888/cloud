package com.george.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * CloudProviderPayment.
 *
 * @author yaofeng 2020-12-14 14:43
 */
@SpringBootApplication
@EnableEurekaServer
public class CloudEurekaServerCluster01 {

	public static void main(String[] args){
		SpringApplication.run(CloudEurekaServerCluster01.class,args);
	}
}
