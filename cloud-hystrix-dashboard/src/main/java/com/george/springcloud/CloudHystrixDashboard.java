package com.george.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * CloudHystrixDashboard.
 *
 * @author yaofeng 2021/1/13 9:55 上午
 */
@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
public class CloudHystrixDashboard {

	public static void main(String[] arg){
		SpringApplication.run(CloudHystrixDashboard.class,arg);
	}
}
