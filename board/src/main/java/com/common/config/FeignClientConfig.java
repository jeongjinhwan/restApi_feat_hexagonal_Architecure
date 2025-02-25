package com.common.config;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;

import feign.Logger;

@Configuration
public class FeignClientConfig {

  @Value("${auth.kma.deckey}")
  public static String bearerName;

  /**
   * feign client log
   * 
   * @return
   */
  @Bean
  Logger.Level feignLoggerLevel() {
    return Logger.Level.FULL;
  }

  @Bean
  @ConditionalOnMissingBean
  public HttpMessageConverters messageConverters(ObjectProvider<HttpMessageConverter<?>> converters) {
    List<HttpMessageConverter<?>> converterList = converters.orderedStream().collect(Collectors.toList());
      converterList.add(new MappingJackson2XmlHttpMessageConverter()); // XML 변환기 추가, KMA error 시 xml 리턴.
      return new HttpMessageConverters(converterList);
  }
}