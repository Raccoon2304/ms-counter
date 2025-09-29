package com.lanit.edp.service;

import com.lanit.edp.dto.WordDto;
import java.util.List;

public interface WordService {

  List<WordDto> getAllWords();

  WordDto save(WordDto wordDto);

  List<WordDto> saveAll(List<WordDto> wordDtos);

}
