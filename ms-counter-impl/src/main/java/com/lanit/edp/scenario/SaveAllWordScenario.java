package com.lanit.edp.scenario;

import com.lanit.edp.dto.PhraseDto;
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

  public List<WordDto> execute(List<PhraseDto> phraseDtos) {

     List<WordDto> wordDtos = phraseDtos.stream()
        .map(phraseDtoToWordDtoMapper::map)
        .collect(Collectors.toList());

     wordService.saveAll(wordDtos);

     return wordDtos;
  }
}
