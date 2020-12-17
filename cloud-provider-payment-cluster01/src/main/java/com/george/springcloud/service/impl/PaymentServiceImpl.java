package com.george.springcloud.service.impl;

import com.george.springcloud.dao.PaymentDao;
import com.george.springcloud.model.Payment;
import com.george.springcloud.service.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * PaymentServiceImpl.
 *
 * @author yaofeng 2020-12-14 15:32
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	private final PaymentDao dao;

	@Autowired
	public PaymentServiceImpl(PaymentDao dao) {
		this.dao = dao;
	}

	@Override
	public int save(Payment payment) {
		return dao.save(payment);
	}

	@Override
	public Payment getOne(Long id) {
		return dao.getOne(id);
	}
}
