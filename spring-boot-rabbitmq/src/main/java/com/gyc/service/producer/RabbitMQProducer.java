package com.gyc.service.producer;

import com.gyc.config.RabbitConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author guo
 * @date 2020/10/2
 */
@Component
public class RabbitMQProducer {

	@Resource
	private RabbitTemplate rabbitTemplate;

	/**
	 * Hello World 模式
	 * @param message 消息内容
	 */
	public void sendOfBasic(String message) {
		rabbitTemplate.convertAndSend(RabbitConfig.KEY_BASIC, message);
	}

	/**
	 * Work 模式
	 * @param message 消息内容
	 */
	public void sendOfWork(String message) {
		rabbitTemplate.convertAndSend(RabbitConfig.KEY_WORK, message);
	}

	/**
	 * Fanout 模式（广播）
	 * @param message 消息内容
	 */
	public void sendOfFanout(String message) {
		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_FANOUT, "", message);
	}

	/**
	 * Routing 模式（路由）
	 * @param message 消息内容
	 */
	public void sendOfRouting(String message) {
//		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_ROUTING, "test", message);
		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_ROUTING, "info", message);
	}

	/**
	 * Topic 模式（动态路由）
	 * @param message 消息内容
	 */
	public void sendOfTopic(String message) {
//		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_TOPIC, "log.info", message);
		rabbitTemplate.convertAndSend(RabbitConfig.EXCHANGE_TOPIC, "log.error.user", message);
	}
}
