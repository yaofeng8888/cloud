package com.george.springcloud.config;

import feign.Logger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FeignLog.
 *
 * @author yaofeng 2021/1/6 4:19 下午
 */
@Configuration
public class FeignLog {

	@Bean
	Logger.Level feignLoggerLevel(){
		return Logger.Level.FULL;//详细日志级别
	}
}
