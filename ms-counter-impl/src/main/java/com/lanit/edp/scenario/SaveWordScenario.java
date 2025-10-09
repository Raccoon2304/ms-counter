package com.lanit.edp.scenario;

import com.lanit.edp.wordcounter.dto.Phrase;
import com.lanit.edp.dto.WordDto;
import com.lanit.edp.mapper.PhraseDtoToWordDtoMapper;
import com.lanit.edp.service.WordService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveWordScenario {

  private final WordService wordService;
  private final PhraseDtoToWordDtoMapper phraseDtoToWordDtoMapper;

  public WordDto execute(Phrase phrase) {
    WordDto wordDto = phraseDtoToWordDtoMapper.map(phrase);
    return wordService.save(wordDto);
  }

}
