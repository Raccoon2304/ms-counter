package com.lanit.edp.scenario;

import com.lanit.edp.wordcounter.dto.Phrase;
import com.lanit.edp.dto.WordDto;
import com.lanit.edp.mapper.PhraseDtoToWordDtoMapper;
import com.lanit.edp.service.WordService;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SaveAllWordScenario {

  private final WordService wordService;
  private final PhraseDtoToWordDtoMapper phraseDtoToWordDtoMapper;

  public List<WordDto> execute(List<Phrase> phrases) {

     List<WordDto> wordDtos = phrases.stream()
        .map(phraseDtoToWordDtoMapper::map)
        .collect(Collectors.toList());

     wordService.saveAll(wordDtos);

     return wordDtos;
  }
}
