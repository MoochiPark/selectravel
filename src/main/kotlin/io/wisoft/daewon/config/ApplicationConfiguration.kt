package io.wisoft.daewon.config

import org.modelmapper.ModelMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ApplicationConfiguration {
  @Bean
  fun modelMapper() = ModelMapper()
}