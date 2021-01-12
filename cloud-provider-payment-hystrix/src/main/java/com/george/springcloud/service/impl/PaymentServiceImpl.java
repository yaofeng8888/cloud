package com.george.springcloud.service.impl;

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
			@HystrixProperty(name = "execution.isolation.thread.timeInMilliseconds",value = "3000")
	})
	public String timeOut(Integer id){
		long begin = System.currentTimeMillis();
		try {
			TimeUnit.SECONDS.sleep(5);
		}catch (Exception e){
			e.printStackTrace();
		}
		long end = System.currentTimeMillis();
		return "线程池 "+Thread.currentThread().getName()+" timeOut id="+id+"耗时"+(end-begin);
	}
	public String timeOutFallback(Integer id){
		return "线程池 "+Thread.currentThread().getName()+" timeOut id="+id+"网络正忙，请稍后再试";
	}
}
