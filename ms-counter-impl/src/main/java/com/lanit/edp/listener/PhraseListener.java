package com.lanit.edp.listener;

import static org.springframework.kafka.support.serializer.ErrorHandlingDeserializer.VALUE_DESERIALIZER_CLASS;
import static org.springframework.kafka.support.serializer.JsonDeserializer.VALUE_DEFAULT_TYPE;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lanit.edp.dto.PhraseDto;
import com.lanit.edp.scenario.SaveWordScenario;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PhraseListener {

  private final ObjectMapper objectMapper;
  private final SaveWordScenario saveWordScenario;

  @KafkaListener(
      topics = "word-counter.request",
      groupId = "my-group",
      properties ={
          VALUE_DEFAULT_TYPE + ":com.lanit.edp.dto.PhraseDto",
          VALUE_DESERIALIZER_CLASS + ":com.lanit.edp.deserializer.CustomDeserializer"
      }
  )
  @SneakyThrows
  public void listen(Message<?> message) {
    PhraseDto phraseDto = (PhraseDto) message.getPayload();

    saveWordScenario.execute(phraseDto);
  }
}
