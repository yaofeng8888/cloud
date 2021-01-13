package com.george.springcloud;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

/**
 * CloudProviderPayment.
 *
 * @author yaofeng 2020-12-14 14:43
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//开启服务降级
public class CloudProviderPaymentHystrix {

	public static void main(String[] args){
		SpringApplication.run(CloudProviderPaymentHystrix.class,args);
	}

	/**
	 *此配置为了服务监控配置，和服务容错本身无关，Springcloud升级后遗留问题、
	 * ServletRegistrationBean因为Springboot的路径不是hystrix.stream
	 *所以需要配置一下servlet
	 */

	@Bean
	public ServletRegistrationBean getServlet(){
		HystrixMetricsStreamServlet hystrixMetricsStreamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean<HystrixMetricsStreamServlet> bean = new ServletRegistrationBean<>(hystrixMetricsStreamServlet);
		bean.setLoadOnStartup(1);
		bean.addUrlMappings("/hystrix.stream");
		bean.setName("HystrixMetricsStreamServlet");
		return bean;
	}
}
