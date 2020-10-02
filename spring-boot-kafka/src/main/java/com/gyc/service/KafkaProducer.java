package com.gyc.service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author guo
 * @date 2020/10/2
 */
@Component
public class KafkaProducer {

	@Resource
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {
		String topic = "test";
//		kafkaTemplate.send(topic, message);
		ProducerRecord<String, String> record = new ProducerRecord<>(topic, message);
		kafkaTemplate.send(record);
	}

}
