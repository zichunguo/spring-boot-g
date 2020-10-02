package com.gyc.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.ByteArrayDeserializer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * @author guo
 * @date 2020/10/2
 */
@Configuration
@EnableKafka
public class KafkaConsumerConfig {
	@Value("${kafka.consumer.bootstrap-servers}")
	private String servers;
	@Value("${kafka.consumer.enable-auto-commit}")
	private boolean enableAutoCommit;
	@Value("${kafka.consumer.auto-commit-interval}")
	private String autoCommitInterval;
	@Value("${kafka.consumer.group-id}")
	private String groupId;
	@Value("${kafka.consumer.auto-offset-reset}")
	private String autoOffsetReset;
	@Value("${kafka.consumer.concurrency}")
	private int concurrency;

	@Bean
	public KafkaListenerContainerFactory<?> batchFactory() {
		ConcurrentKafkaListenerContainerFactory<String, byte[]> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(new DefaultKafkaConsumerFactory<>(consumerConfigs()));
		//并发数量
		factory.setConcurrency(concurrency);
		//批量获取
		factory.setBatchListener(true);
		factory.getContainerProperties().setPollTimeout(1500);
		return factory;
	}

	public Map<String, Object> consumerConfigs() {
		Map<String, Object> propsMap = new HashMap<>();
		propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
		propsMap.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, enableAutoCommit);
		propsMap.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, autoCommitInterval);
		propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ByteArrayDeserializer.class);
		propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
		propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
		//最多批量获取50个
		propsMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG,100);
		return propsMap;
	}

}
