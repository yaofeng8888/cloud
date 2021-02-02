package com.george.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * CloudStreamConsumer.
 *
 * @author yaofeng 2021/2/2 3:25 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudStreamConsumer {

	public static void main(String[] args){
		SpringApplication.run(CloudStreamConsumer.class);
	}
}
