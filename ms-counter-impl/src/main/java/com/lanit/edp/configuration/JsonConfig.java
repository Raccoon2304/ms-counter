package com.lanit.edp.configuration;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import com.fasterxml.jackson.databind.jsontype.TypeIdResolver;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.lanit.edp.deserializer.OffsetDateTimeDeserializer;
import java.time.OffsetDateTime;
import java.util.TimeZone;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JsonConfig {

  public static ObjectMapper jsonMapper() {
    return new ObjectMapper()
        .setTimeZone(TimeZone.getTimeZone("UTC"))
        .enable(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES)
        .disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES)
        .disable(SerializationFeature.FAIL_ON_EMPTY_BEANS)
        .setVisibility(PropertyAccessor.FIELD, Visibility.ANY)
        .registerModule(new JavaTimeModule())
        .registerModule(new SimpleModule()
            .addDeserializer(OffsetDateTime.class, new OffsetDateTimeDeserializer())
        )
        .setSerializationInclusion(Include.NON_NULL)
        .addHandler(new UnMarshallingErrorHandler())
        .configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
  }

  static final class UnMarshallingErrorHandler extends DeserializationProblemHandler {
    @Override
    public JavaType handleUnknownTypeId(DeserializationContext ctx, JavaType baseType, String subTypeId,
        TypeIdResolver idResolver, String failureMsg) {
      return baseType;
    }
  }

}
