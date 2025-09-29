package com.lanit.edp.controllers;

import com.lanit.edp.dto.WordDto;
import com.lanit.edp.scenario.GetWorldScenario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordTestController {

  @Autowired
  private GetWorldScenario worldScenario;

  public List<WordDto> getAll() {
    return worldScenario.execute();
  }

}
