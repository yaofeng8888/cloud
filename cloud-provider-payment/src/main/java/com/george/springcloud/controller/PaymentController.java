package com.george.springcloud.controller;

import cn.hutool.json.JSONObject;
import com.george.springcloud.model.ApiResult;
import com.george.springcloud.model.Payment;
import com.george.springcloud.service.PaymentService;

import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * PaymentController.
 *
 * @author yaofeng 2020-12-14 15:35
 */
@Controller
@Slf4j
public class PaymentController {


	@Value("${server.port}")
	private String serverPort;

	@Autowired
	private final PaymentService service;

	@Autowired
	private DiscoveryClient discoveryClient;

	public PaymentController(PaymentService service) {
		this.service = service;
	}

	@PostMapping("save")
	@ResponseBody
	public ApiResult save(Payment payment){
		int save = service.save(payment);
		if (save>0){
			log.info("数据插入成功");
			return new ApiResult(200,"数据插入成功,serverPort="+serverPort,save);
		}else {
			log.info("数据插入失败");
			return new ApiResult(500,"数据插入失败",null);
		}

	}
	@GetMapping("getOne/{id}")
	@ResponseBody
	public ApiResult<Payment> findOne(@PathVariable("id") Long id){
		Payment payment = service.getOne(id);
		if (payment!=null){

			return new ApiResult(200,"查询成功,serverPort="+serverPort,payment);
		}else {
			return new ApiResult(500,"没有对应记录，ID为:"+id,null);
		}
	}

	@GetMapping("/payment/discovery")
	@ResponseBody
	public Object discovery(){
		Map<String,Object> map = new HashMap<>();
		List<String> services = discoveryClient.getServices();
		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
		map.put("service",services);
		for (ServiceInstance in:instances) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("serviceId",in.getServiceId());
			jsonObject.put("host",in.getHost());
			jsonObject.put("port",in.getPort());
			jsonObject.put("RUI",in.getUri());
			map.put(in.getInstanceId(),jsonObject);
			System.out.println(in.getInstanceId()+"----"+in.getHost()+"----"+in.getPort()+"----"+in.getUri());
		}
		return map;
	}

	@GetMapping("/payment/Lb")
	public String getPaymentLb(){
		return serverPort;
	}

	@GetMapping("/payment/timeout")
	@ResponseBody
	public String timeout() {
		try {
			TimeUnit.SECONDS.sleep(3);
		}catch (Exception e){
			e.printStackTrace();
		}
		return serverPort;
	}
}
