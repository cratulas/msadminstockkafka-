package com.example.msadminstockkafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

@Bean
public NewTopic stockTopic() {
    return new NewTopic("stock", 3, (short) 3);
}
}
