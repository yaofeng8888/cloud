package com.george.springcloud.config;

import com.sun.org.apache.regexp.internal.RE;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * RestConfig.
 *
 * @author yaofeng 2021/2/4 5:03 下午
 */
@Configuration
public class RestConfig {


	@Bean
	@LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
}
