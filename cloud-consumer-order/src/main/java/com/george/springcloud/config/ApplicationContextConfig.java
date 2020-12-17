package com.george.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * ApplicationContextConfig.
 *
 * @author yaofeng 2020-12-17 17:05
 */
@Configuration
public class ApplicationContextConfig {


	@Bean
	@LoadBalanced  //@LoadBalanced注解赋予了RestTemplate具有负载均衡的能力
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
}
