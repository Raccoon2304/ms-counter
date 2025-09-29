package com.lanit.edp.scenario;

import com.lanit.edp.dto.WordDto;
import com.lanit.edp.service.WordService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetWorldScenario {

  private final WordService wordService;

  public List<WordDto> execute() {
    return wordService.getAllWords();
  }

}
