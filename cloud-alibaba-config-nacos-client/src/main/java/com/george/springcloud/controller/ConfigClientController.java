package com.george.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConfigClientController.
 *
 * @author yaofeng 2021/2/5 2:00 下午
 */
@RestController
@RefreshScope//自动刷新
public class ConfigClientController {
	@Value("${config.info}")
	private String config;

	@RequestMapping("/getConfig")
	public String getConfig(){
		return config;
	}
}
