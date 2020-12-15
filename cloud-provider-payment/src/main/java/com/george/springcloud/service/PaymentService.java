package com.george.springcloud.service;

import com.george.springcloud.model.Payment;

/**
 * PaymentService.
 *
 * @author yaofeng 2020-12-14 15:32
 */
public interface PaymentService {

	int save(Payment payment);

	Payment getOne(Long id);
}
