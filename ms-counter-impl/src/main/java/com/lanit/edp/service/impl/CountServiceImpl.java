package com.lanit.edp.service.impl;

import com.lanit.edp.wordcounter.dto.Phrase;
import com.lanit.edp.service.CountService;
import java.util.Arrays;
import org.springframework.stereotype.Service;

@Service
public class CountServiceImpl implements CountService {

  @Override
  public Long count(Phrase phrase) {
    String text = phrase.getText();
    Long count = Arrays.stream(text.split(" ")).count();

    return count;
  }
}
