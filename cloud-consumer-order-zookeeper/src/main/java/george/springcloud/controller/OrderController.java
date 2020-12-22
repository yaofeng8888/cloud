package george.springcloud.controller;

import com.george.springcloud.model.ApiResult;
import com.george.springcloud.model.Payment;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * OrderController.
 *
 * @author yaofeng 2020-12-14 17:42
 */
@RestController
public class OrderController {
	public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-ZOOKEEPER";

	@Resource
	private RestTemplate restTemplate;

	@GetMapping("/getOne/{id}")
	public ApiResult<Payment> getPayment(@PathVariable("id") Long id) {
		System.out.println("---------订单系统-----------");
		return restTemplate.getForObject(PAYMENT_URL + "/getOne/" + id, ApiResult.class);
	}

}
