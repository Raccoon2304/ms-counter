package com.lanit.edp.service;

import com.lanit.edp.wordcounter.dto.Phrase;

public interface CountService {

  Long count(Phrase phrase);

}
