package com.george.springcloud.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringUtils;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ServerWebExchange;

/**
 * FiltetUtil.
 *
 * @author yaofeng 2021/1/25 3:58 下午
 */
public class FilterUtil {

	public static Mono<Void> consumerRes(ServerWebExchange exchange,Integer code,String msg){
		Map<String,Object> resultMap = new HashMap<>();
		resultMap.put("code",code);
		resultMap.put("msg", StringUtils.isBlank(msg)?"服务异常":msg);
		return Mono.defer(()->{
			byte[] bytes = new byte[0];
			try {
				bytes = new ObjectMapper().writeValueAsBytes(resultMap);
			}catch (JsonProcessingException e){
				e.printStackTrace();
			}
			ServerHttpResponse response = exchange.getResponse();
			response.getHeaders().add("Content-Type", MediaType.APPLICATION_JSON_VALUE);
			DataBuffer wrap = response.bufferFactory().wrap(bytes);
			return response.writeWith(Flux.just(wrap));
		});
	}
}
