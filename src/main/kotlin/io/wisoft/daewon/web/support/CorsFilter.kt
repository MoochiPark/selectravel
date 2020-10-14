package io.wisoft.daewon.web.support

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.Ordered
import org.springframework.core.annotation.Order
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.reactive.CorsWebFilter
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource

@CrossOrigin
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
class CorsFilter {

  @Bean
  fun corsWebFilter(): CorsWebFilter {
    val source = UrlBasedCorsConfigurationSource()
    val config = CorsConfiguration()
    config.addAllowedOrigin("*")
    config.addAllowedHeader("*")
    config.addAllowedMethod("OPTIONS")
    config.addAllowedMethod("GET")
    config.addAllowedMethod("PUT")
    config.addAllowedMethod("POST")
    config.addAllowedMethod("DELETE")
    config.addAllowedMethod("PATCH")

    source.registerCorsConfiguration("/**", config)

    return CorsWebFilter(source)
  }

}