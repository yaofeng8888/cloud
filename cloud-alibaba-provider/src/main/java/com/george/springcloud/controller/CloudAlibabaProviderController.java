package com.george.springcloud.controller;

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
public class CloudAlibabaProviderController {

	@Value("${server.port}")
	private String serverPort;


	@RequestMapping("/provider/{id}")
	public String getPort(@PathVariable("id")Integer id){
		return "this is provider,your id is "+id+"this.provider serverPort is "+serverPort;
	}
}
