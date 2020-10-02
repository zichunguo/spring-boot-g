package com.gyc.service.consumer;

import com.gyc.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 测试第三种消息模型：订阅模型-fanout（广播）-- 消费者
 * 效果：exchange 将消息发到所有消息队列（广播）
 * @author guo
 * @date 2020/10/2
 */
@Component
public class FanoutConsumer {

	@RabbitListener(bindings = {
			@QueueBinding(
					value = @Queue,// 创建临时队列
//					value = @Queue("test_queue_fanout1"),
					exchange = @Exchange(value = RabbitConfig.EXCHANGE_FANOUT, type = "fanout")// 绑定的交换机
			)
	})
	public void receive(String message) {
		System.out.println("Fanout 模式，消费者1：" + message);
	}

	@RabbitListener(bindings = {
			@QueueBinding(
					value = @Queue,// 创建临时队列
//					value = @Queue("test_queue_fanout2"),
					exchange = @Exchange(name = RabbitConfig.EXCHANGE_FANOUT, type = "fanout")// 绑定的交换机，name 和 value 属性相同
			)
	})
	public void receive2(String message) {
		System.out.println("Fanout 模式，消费者2：" + message);
	}
}
