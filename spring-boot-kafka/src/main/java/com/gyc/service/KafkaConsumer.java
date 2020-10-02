package com.gyc.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 不使用并发获取、批量获取的消费者
 * @author guo
 * @date 2020/10/2
 */
//@Component
public class KafkaConsumer {

	@KafkaListener(topics = "test")
	public void receiveMessage(String message) {
		System.out.println("*****************: " + message);
	}

}
