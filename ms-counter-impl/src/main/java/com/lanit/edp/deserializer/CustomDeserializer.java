package com.lanit.edp.deserializer;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lanit.edp.dto.PhraseDto;
import java.io.IOException;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

@Slf4j
public class CustomDeserializer implements Deserializer<PhraseDto> {

  private ObjectMapper objectMapper;

  public CustomDeserializer() {
    this.objectMapper = new ObjectMapper();
    // Регистрация модуля обработки времени и дат
    this.objectMapper.registerModule(new JavaTimeModule());
  }

    @Override
  public PhraseDto deserialize(String topic, byte[] data) {
    try {
      return objectMapper.readValue(data, PhraseDto.class);
    } catch (IOException e) {
      throw new RuntimeException("Ошибка при десериализации JSON", e);
    }
  }
}

