package com.george.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.george.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * PaymentController.
 *
 * @author yaofeng 2020-12-14 15:35
 */
@Service
@Slf4j
public class PaymentServiceImpl implements PaymentService {


	@Value("${server.port}")
	private String serverPort;

	public String payment_OK(Integer id){
		return "线程池 "+Thread.currentThread().getName()+" isOK  id="+id;
	}

	@HystrixCommand(fallbackMethod = "timeOutFallback",commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")
	})
	public String timeOut(Integer id){
		long begin = System.currentTimeMillis();
//		int i = 10/0;
		try {
			TimeUnit.SECONDS.sleep(3);
		}catch (Exception e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		return "线程池 "+Thread.currentThread().getName()+" timeOut id="+id+"耗时"+(end-begin);
	}
	public String timeOutFallback(Integer id){
		return "线程池 "+Thread.currentThread().getName()+" timeOut id="+id+"网络正忙，请稍后再试";
	}

	@HystrixCommand(fallbackMethod ="paymentBreakFallback",commandProperties={
			@HystrixProperty(name = "circuitBreaker.enabled", value = "true"), //是否开启断路器
			@HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), //请求次数
			@HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), //时间窗口期
			@HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),//失败率达到多少后跳闸
	})
	@Override
	public String paymentBreak(Integer id) {
		if (id<0){
			throw new RuntimeException("id 不能为负数");
		}
		String uuid = IdUtil.simpleUUID();
		return Thread.currentThread().getName()+"流水号："+uuid;
	}

	public String paymentBreakFallback(Integer id){
		return "id 不能为负数 "+id;
	}
}
