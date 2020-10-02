package com.gyc.controller;

import com.gyc.service.KafkaProducer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author guo
 * @date 2020/10/2
 */
@RestController
public class KafkaController {
	@Resource
	private KafkaProducer kafkaProducer;

	@RequestMapping("/send/{message}")
	public String sendMessage(@PathVariable("message") String message) {
		kafkaProducer.sendMessage(message);
		return "send : " + message;
	}
}
