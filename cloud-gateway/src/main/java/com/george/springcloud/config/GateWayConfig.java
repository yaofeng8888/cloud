package com.george.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * GateWayConfig.
 *
 * @author yaofeng 2021/1/14 2:39 下午
 */
@Configuration
public class GateWayConfig {

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder){
		RouteLocatorBuilder.Builder routes = builder.routes();
		routes.route("path_route",
				r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
		return routes.build();
	}
	@Bean
	public RouteLocator customRouteLocator2(RouteLocatorBuilder builder){
		RouteLocatorBuilder.Builder routes = builder.routes();
		routes.route("path_route",
				r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();
		return routes.build();
	}
}
