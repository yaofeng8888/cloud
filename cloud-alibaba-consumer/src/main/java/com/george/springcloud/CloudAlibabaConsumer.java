package com.george.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * CloudAlibabaConsumer.
 *
 * @author yaofeng 2021/2/4 4:54 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaConsumer {

	public static void main(String[] strings){
		SpringApplication.run(CloudAlibabaConsumer.class,strings);
	}
}
