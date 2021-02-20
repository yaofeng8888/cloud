package com.george.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * CloudAlibabaConfigClient.
 *
 * @author yaofeng 2021/2/5 1:59 下午
 */
@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaConfigClient {

	public static void main(String[] strings){
		SpringApplication.run(CloudAlibabaConfigClient.class,strings);
	}
}
