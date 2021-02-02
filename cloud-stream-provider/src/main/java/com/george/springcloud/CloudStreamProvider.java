package com.george.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * CloudStreamPorvider.
 *
 * @author yaofeng 2021/2/2 2:22 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudStreamProvider {

	public static void main(String[] args ){
		SpringApplication.run(CloudStreamProvider.class,args);
	}
}
