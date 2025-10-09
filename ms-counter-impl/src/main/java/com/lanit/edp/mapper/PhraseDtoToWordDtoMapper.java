package com.lanit.edp.mapper;

import com.lanit.edp.wordcounter.dto.Phrase;
import com.lanit.edp.dto.WordDto;
import com.lanit.edp.service.CountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PhraseDtoToWordDtoMapper {

  private final CountService countService;

  public WordDto map(Phrase phrase) {
    WordDto wordDto = new WordDto();
    wordDto.setSysCreateDate(phrase.getSysCreateDate());
    wordDto.setText(phrase.getText());
    wordDto.setCount(countService.count(phrase));

    return wordDto;
  }

}
