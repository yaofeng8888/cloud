package com.george.springcloud.feign.impl;

import com.george.springcloud.feign.PaymentHystrixService;

import org.springframework.stereotype.Component;

/**
 * PaymentHystrixServiceImpl.
 *
 * @author yaofeng 2021/1/12 1:54 下午
 */
@Component
public class PaymentHystrixServiceImpl implements PaymentHystrixService {
	@Override
	public String getPayment_OK(Long id) {
		return "系统正忙，请稍后再试！编号："+id;
	}

	@Override
	public String getTimeout(Long id) {
		return "系统正忙，请稍后再试！编号："+id;
	}
}
