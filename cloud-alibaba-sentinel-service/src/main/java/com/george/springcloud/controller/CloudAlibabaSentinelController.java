package com.george.springcloud.controller;

import com.alibaba.csp.sentinel.util.TimeUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CloudAlibabaProviderController.
 *
 * @author yaofeng 2021/2/4 4:45 下午
 */
@RestController
@Slf4j
public class CloudAlibabaSentinelController {

	@Value("${server.port}")
	private String serverPort;


	@RequestMapping("sentinel")
	public String getPort(){
		return "this is sentinel server "+serverPort;
	}


	@RequestMapping("sentinelA")
	public String getPortA(){
		log.info(Thread.currentThread().getName()+"....sentinelA");
		return "this is sentinel serverA "+serverPort;
	}


	@RequestMapping("sentinelB")
	public String getPortB(){
		try {
			TimeUnit.SECONDS.sleep(1);
		}catch (InterruptedException e){
			e.printStackTrace();
		}
		log.info(Thread.currentThread().getName()+"....sentinelB");
		return "this is sentinel serverB "+serverPort;
	}

	@RequestMapping("sentinelC")
	public String getPortC(){
		int c =10/0;
		log.info(Thread.currentThread().getName()+"....sentinelB");
		return "this is sentinel serverB "+serverPort;
	}
}
