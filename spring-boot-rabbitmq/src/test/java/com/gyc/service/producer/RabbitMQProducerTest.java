package com.gyc.service.producer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author guo
 * @date 2020/10/2
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RabbitMQProducerTest {

	@Autowired
	private RabbitMQProducer rabbitMQProducer;

	// 测试 Hello World 模式
	@Test
	public void sendOfBasic() {
		rabbitMQProducer.sendOfBasic("hello");
	}

	// 测试 Work 模式
	@Test
	public void sendOfWork() {
		for (int i = 0; i < 10; i++) {
			rabbitMQProducer.sendOfWork("work message " + i);
		}
	}

	// 测试 Fanout 模式
	@Test
	public void sendOfFanout() {
		rabbitMQProducer.sendOfFanout("fanout message");
	}

	// 测试 Routing 模式
	@Test
	public void testRouting() {
		rabbitMQProducer.sendOfRouting("routing message");
	}

	// 测试 Topic 模式
	@Test
	public void testTopic() {
		rabbitMQProducer.sendOfTopic("Topic message");
	}

}
