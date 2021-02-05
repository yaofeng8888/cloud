package com.george.springcloud.controlelr;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * CloudAlibabaConsumerControler.
 *
 * @author yaofeng 2021/2/4 4:55 下午
 */
@RestController
public class CloudAlibabaConsumerController {

	@Value("${server.port}")
	private String serverPort;

	@Value("${service-url.nacos-user-service}")
	private String url;

	@Autowired
	private RestTemplate template;

	@RequestMapping("/consumer/provider/{id}")
	public String getPort(@PathVariable("id") Integer id){
		String result = template.getForObject(url + "/provider/" + id, String.class);
		return "this is consumer your result is "+result+" this consumer serverPost is "+serverPort;
	}
}
