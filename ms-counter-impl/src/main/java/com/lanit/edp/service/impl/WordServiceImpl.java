package com.lanit.edp.service.impl;

import com.lanit.edp.dto.WordDto;
import com.lanit.edp.entity.WordEntity;
import com.lanit.edp.mapper.WordMapper;
import com.lanit.edp.repository.WordRepository;
import com.lanit.edp.service.WordService;
import java.util.Arrays;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WordServiceImpl implements WordService {

  private final WordRepository wordRepository;

  private final WordMapper wordMapper;

  @Override
  public List<WordDto> getAllWords() {
    List<WordEntity> wordEntities = wordRepository.findAll();

    return wordMapper.mapAsList(wordEntities, WordDto.class);
  }

  @Override
  public WordDto save(WordDto wordDto) {
    WordEntity wordEntity = wordMapper.map(wordDto, WordEntity.class);
    WordEntity wordEntitySaved = wordRepository.save(wordEntity);
    if (wordEntitySaved != null) {
      return wordMapper.map(wordEntitySaved, WordDto.class);
    }
    return new WordDto();
  }

  @Override
  public List<WordDto> saveAll(List<WordDto> wordDtos) {

    List<WordEntity> wordEntities = wordMapper.mapAsList(wordDtos, WordEntity.class);
    List<WordEntity> wordEntitySaved = wordRepository.saveAll(wordEntities);
    if (!wordEntitySaved.isEmpty()) {
      return wordMapper.mapAsList(wordEntitySaved, WordDto.class);
    }
    return Arrays.asList(new WordDto());
  }
}
