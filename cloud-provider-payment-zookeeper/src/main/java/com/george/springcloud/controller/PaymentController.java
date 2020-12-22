package com.george.springcloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * PaymentController.
 *
 * @author yaofeng 2020-12-14 15:35
 */
@Controller
public class PaymentController {

	@Value("${server.port}")
	private String serverPort;


	@RequestMapping("getPort")
	@ResponseBody
	public String getPort(){
		return serverPort;
	}
}
