package com.lanit.edp.entity;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "word")
public class WordEntity {

  @Id
  @SequenceGenerator(name = "word_changelog_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "word_changelog_seq")
  private Long id;

  @Column(name = "sys_create_date")
  private OffsetDateTime sysCreateDate;

  @Column(name = "text")
  private String text;

  @Column(name = "count")
  private Long count;

}
