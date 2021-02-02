package com.george.springcloud.service.impl;

import com.george.springcloud.service.IMessageService;

import javax.annotation.Resource;

import java.util.UUID;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

/**
 * IMessageServiceImpl.
 *
 * @author yaofeng 2021/2/2 2:36 下午
 */
@EnableBinding(Source.class)//定义消息推送管道
public class IMessageServiceImpl implements IMessageService {

	//消息发送管道
	@Resource
	private MessageChannel output;

	@Override
	public String sendMessage() {
		String message = UUID.randomUUID().toString();
		output.send(MessageBuilder.withPayload(message).build());
		return message;
	}
}
