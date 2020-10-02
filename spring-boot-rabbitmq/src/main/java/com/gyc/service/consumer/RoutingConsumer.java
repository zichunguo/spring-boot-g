package com.gyc.service.consumer;

import com.gyc.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 测试第四种消息模型：订阅模型-Direct（Routing）-- 消费者
 * 效果：根据路由key，exchange 将消息发到对应的消息队列（路由）
 * @author guo
 * @date 2020/10/2
 */
@Component
public class RoutingConsumer {

	@RabbitListener(bindings = {
			@QueueBinding(
					value = @Queue,
//					value = @Queue("test_queue_routing1"),
					exchange = @Exchange(value = RabbitConfig.EXCHANGE_ROUTING, type = "direct"), // 交换机默认类型为 direct
					key = {"test", "info"}
			)
	})
	public void receive(String message) {
		System.out.println("Routing 模式，消费者1：" + message);
	}

	@RabbitListener(bindings = {
			@QueueBinding(
					value = @Queue,
//					value = @Queue("test_queue_routing2"),
					exchange = @Exchange(value = RabbitConfig.EXCHANGE_ROUTING, type = "direct"), // 交换机默认类型为 direct
					key = {"info"}
			)
	})
	public void receive2(String message) {
		System.out.println("Routing 模式，消费者2：" + message);
	}
}
