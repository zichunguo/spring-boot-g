package com.gyc.service.consumer;

import com.gyc.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 测试第二种消息模型：work 消息模型（Work queues）-- 消费者
 *  默认情况下，RabbitMQ 会轮询的方式将消息发给每个消费者（平均分配）。
 *  Work 模式消费时，RabbitMQ 会公平的将消息分配给每个消费者
 * @author guo
 * @date 2020/10/2
 */
@Component
public class WorkConsumer {

	@RabbitListener(queuesToDeclare = @Queue(RabbitConfig.KEY_WORK))
	public void receive(String message) {
		System.out.println("Work 模式，消费者1：" + message);
	}

	@RabbitListener(queuesToDeclare = @Queue(RabbitConfig.KEY_WORK))
	public void receive2(String message) {
		System.out.println("Work 模式，消费者2：" + message);
	}

	// 疑问：如何实现注解方式手动确认消息
}
