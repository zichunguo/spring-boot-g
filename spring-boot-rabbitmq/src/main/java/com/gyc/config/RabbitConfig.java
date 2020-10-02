package com.gyc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 测试第三种消息模型：订阅模型-Fanout（Publish/Subscribe）-- 消费者
 * 效果：每个队列都会收到一份消息内容（广播）
 * @author guo
 * @date 2020/10/2
 */
@Configuration
public class RabbitConfig {

	public static final String KEY_BASIC = "test_basic";// Hello World 模式的 RoutingKey，即队列名
	public static final String KEY_WORK = "test_work";// Work 模式的 RoutingKey，即队列名
	public static final String EXCHANGE_FANOUT = "test_exchange_fanout";// Fanout 模式（广播）exchange 名
	public static final String EXCHANGE_ROUTING = "test_exchange_routing";// Routing 模式（路由）exchange 名
	public static final String EXCHANGE_TOPIC = "test_exchange_topic";// Topic 模式（动态路由）exchange 名

	// 以下 bean 只是配置测试使用配置类创建队列，可以通过注解的形式不用以下内容
	@Bean
	public Queue basicQueue() {
		return new Queue(KEY_BASIC);
	}

	@Bean
	public Queue WorkQueue() {
		return new Queue(KEY_WORK);
	}

}
