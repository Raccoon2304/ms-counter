package com.lanit.edp.dto;

import java.time.OffsetDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PhraseDto {

  private Long id;

  private OffsetDateTime sysCreateDate;

  private String text;

}
