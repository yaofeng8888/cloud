package com.george.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * MySelfRule.
 *  自定义Ribbon负载均衡规则
 *  @author yaofeng 2020-12-24 14:54
 */
@Configuration
public class MySelfRule {

	@Bean   //自定义为随机算法
	public IRule myRule(){
		return new RandomRule();
	}
}
