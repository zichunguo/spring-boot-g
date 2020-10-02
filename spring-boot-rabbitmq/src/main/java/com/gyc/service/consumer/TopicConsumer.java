package com.gyc.service.consumer;

import com.gyc.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 测试第五种消息模型：订阅模型-Topic（Topics）-- 消费者
 * 效果：动态路由，根据路由key（可以使用通配符“*”、“#”），动态匹配，exchange 将消息发到对应的消息队列
 * @author guo
 * @date 2020/10/2
 */
@Component
public class TopicConsumer {

	@RabbitListener(bindings = {
			@QueueBinding(
//					value = @Queue,
					value = @Queue("test_queue_topic1"),
					exchange = @Exchange(value = RabbitConfig.EXCHANGE_TOPIC, type = "topic"),
					key = {"log.info", "log.*"}
			)
	})
	public void receive(String message) {
		System.out.println("Topic 模式，消费者1：" + message);
	}

	@RabbitListener(bindings = {
			@QueueBinding(
//					value = @Queue,
					value = @Queue("test_queue_topic2"),
					exchange = @Exchange(value = RabbitConfig.EXCHANGE_TOPIC, type = "topic"),
					key = {"log.error", "log.#"}
			)
	})
	public void receive2(String message) {
		System.out.println("Topic 模式，消费者2：" + message);
	}

}
