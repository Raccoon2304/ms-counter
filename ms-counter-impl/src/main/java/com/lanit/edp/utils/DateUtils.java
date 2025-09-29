package com.lanit.edp.utils;

import java.time.OffsetDateTime;
import java.time.temporal.ChronoUnit;
import lombok.experimental.UtilityClass;

@UtilityClass
public class DateUtils {

  public static OffsetDateTime trimNano(OffsetDateTime dateTime) {
    if (dateTime == null) {
      return null;
    }
    return dateTime.truncatedTo(ChronoUnit.SECONDS);
  }

}
