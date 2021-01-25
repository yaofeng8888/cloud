package com.george.springcloud.config;

import com.george.springcloud.util.FilterUtil;
import org.apache.commons.lang.StringUtils;
import reactor.core.publisher.Mono;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

/**
 * GateWayFilter.
 *
 * @author yaofeng 2021/1/25 3:39 下午
 */
@Component
public class GateWayFilter implements GlobalFilter, Ordered {
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		String userName = exchange.getRequest().getQueryParams().getFirst("userName");
		//开始业务逻辑
		if (StringUtils.isEmpty(userName)){
//			exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
//			return exchange.getResponse().setComplete();
			return FilterUtil.consumerRes(exchange,500,"非法用户");
		}else if (StringUtils.equals(userName,"zhangdd")){
			return FilterUtil.consumerRes(exchange,200,"用户名不正确");
		}
		return chain.filter(exchange);
	}

	@Override
	public int getOrder() {
		return 0;
	}
}
