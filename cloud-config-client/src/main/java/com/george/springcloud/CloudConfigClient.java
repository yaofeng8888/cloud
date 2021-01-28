package com.george.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * CloudConfigClient.
 *
 * @author yaofeng 2021/1/28 4:08 下午
 */
@SpringBootApplication
@EnableEurekaClient
public class CloudConfigClient {

	public static void main(String[] strings){
		SpringApplication.run(CloudConfigClient.class,strings);
	}
}
