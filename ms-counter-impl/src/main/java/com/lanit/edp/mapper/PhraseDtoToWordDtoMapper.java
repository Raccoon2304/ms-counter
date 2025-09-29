package com.lanit.edp.mapper;

import com.lanit.edp.dto.PhraseDto;
import com.lanit.edp.dto.WordDto;
import com.lanit.edp.service.CountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PhraseDtoToWordDtoMapper {

  private final CountService countService;

  public WordDto map(PhraseDto phraseDto) {
    WordDto wordDto = new WordDto();
    wordDto.setSysCreateDate(phraseDto.getSysCreateDate());
    wordDto.setText(phraseDto.getText());
    wordDto.setCount(countService.count(phraseDto));

    return wordDto;
  }

}
