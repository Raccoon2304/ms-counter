package com.lanit.edp.service.impl;

import com.lanit.edp.dto.PhraseDto;
import com.lanit.edp.service.CountService;
import java.util.Arrays;
import org.springframework.stereotype.Service;

@Service
public class CountServiceImpl implements CountService {

  @Override
  public Long count(PhraseDto phraseDto) {
    String text = phraseDto.getText();
    Long count = Arrays.stream(text.split(" ")).count();

    return count;
  }
}
