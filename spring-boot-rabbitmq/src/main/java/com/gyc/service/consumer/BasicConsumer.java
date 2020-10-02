package com.gyc.service.consumer;

import com.gyc.config.RabbitConfig;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 测试第一种消息模型：basic 消息模型（Hello World）-- 消费者
 * @author guo
 * @date 2020/10/2
 */
@Component
//@RabbitListener(queues = RabbitConfig.KEY_BASIC)// 用此方法是绑定队列，该队列必须已经存在，不会自动创建
@RabbitListener(queuesToDeclare = @Queue(RabbitConfig.KEY_BASIC)) // 用此方法是声明队列，该队列不存在时自动创建
// 默认创建持久化的不独占的不自动删除的队列，具体设置可以参考如下配置
//@RabbitListener(queuesToDeclare = @Queue(value = RabbitConfig.KEY_BASIC, durable = "true", exclusive = "false", autoDelete = "false"))
public class BasicConsumer {
	@RabbitHandler
	public void receive(String message) {
		System.out.println("Basic 模式，消费者：" + message);
	}
}
