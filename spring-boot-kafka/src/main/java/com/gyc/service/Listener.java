package com.gyc.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author guo
 * @date 2020/10/2
 */

@Service
public class Listener {
	private final String topic = "test";

	@KafkaListener(topics = topic, id = "consumer", containerFactory = "batchFactory")
	public void listen2(List<ConsumerRecord<String, byte[]>> list) {
		System.out.println("**** size : " + list.size());
		list.forEach((record)->{
//			System.out.println("kafka的key: " + record.key());
			System.out.println("kafka的value: " + new String(record.value()));
		});
		System.out.println("******* :" + Thread.currentThread().getName());
	}

}
