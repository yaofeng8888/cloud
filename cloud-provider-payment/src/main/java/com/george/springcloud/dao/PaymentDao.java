package com.george.springcloud.dao;

import com.george.springcloud.model.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * PaymentDao.
 *
 * @author yaofeng 2020-12-14 15:20
 */
@Mapper
public interface PaymentDao {

	int save(Payment payment);


	Payment getOne(@Param("id") Long id);
}
