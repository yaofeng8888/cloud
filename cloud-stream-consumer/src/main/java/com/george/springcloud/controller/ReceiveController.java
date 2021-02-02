package com.george.springcloud.controller;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ReceiveController.
 *
 * @author yaofeng 2021/2/2 3:26 下午
 */
@RestController
@EnableBinding(Sink.class)
public class ReceiveController {

	@Value("${server.port}")
	private String serverPort;

	private String mess;

	@StreamListener(Sink.INPUT)
	public void getMessage(Message<String> message){
		mess = message.getPayload()+serverPort;
	}

	@GetMapping("getMessage")
	public String Message(){
		return mess;
	}
}
