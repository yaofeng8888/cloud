package com.george.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * CloudAlibabaProvider.
 *
 * @author yaofeng 2021/2/4 4:43 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaSentinel {

	public static void main(String[] args){
		SpringApplication.run(CloudAlibabaSentinel.class,args);
	}
}
