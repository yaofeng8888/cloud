package com.george.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ConfigController.
 *
 * @author yaofeng 2021/1/28 4:10 下午
 */
@RestController
@RefreshScope
public class ConfigController {

	@Value("${config.info}")
	private String config;

	@RequestMapping("getConfig")
	public String getConfig(){
		return config;
	}
}
