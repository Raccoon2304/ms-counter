package com.lanit.edp.wordcounter.dto;

import java.time.OffsetDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Phrase {

  private Long id;

  private OffsetDateTime sysCreateDate;

  private String text;

}
