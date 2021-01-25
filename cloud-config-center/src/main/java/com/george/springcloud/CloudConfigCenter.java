package com.george.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * CloudConfigCenter.
 *
 * @author yaofeng 2021/1/25 5:28 下午
 */
@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class CloudConfigCenter {

	public static void main(String[] args){
		SpringApplication.run(CloudConfigCenter.class,args);
	}
}
