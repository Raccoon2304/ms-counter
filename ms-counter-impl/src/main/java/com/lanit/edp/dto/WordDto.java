package com.lanit.edp.dto;

import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class WordDto {

  private Long id;

  private OffsetDateTime sysCreateDate;

  private String text;

  private Long count;

}
