package com.lanit.edp.mapper;

import com.lanit.edp.dto.WordDto;
import com.lanit.edp.entity.WordEntity;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;

@Component
public class WordMapper extends ConfigurableMapper {

  @Override
  public void configure(MapperFactory mapperFactory) {
    mapperFactory.classMap(WordDto.class, WordEntity.class)
        .field("id", "id")
        .field("sysCreateDate", "sysCreateDate")
        .field("text", "text")
        .field("count", "count")
        .byDefault()
        .register();
  }

}
