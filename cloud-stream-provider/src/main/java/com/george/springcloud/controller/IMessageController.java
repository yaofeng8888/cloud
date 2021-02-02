package com.george.springcloud.controller;

import com.george.springcloud.service.IMessageService;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * IMessageController.
 *
 * @author yaofeng 2021/2/2 2:50 下午
 */
@RestController
public class IMessageController {

	@Resource
	private IMessageService iMessageService;

	@GetMapping("send")
	public String sendMessage(){
		return iMessageService.sendMessage();
	}
}
