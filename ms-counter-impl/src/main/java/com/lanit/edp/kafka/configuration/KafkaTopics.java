package com.lanit.edp.kafka.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("app.kafka.topic")
public class KafkaTopics {

  private String wordCounterRequest;

}
