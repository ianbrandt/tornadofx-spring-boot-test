package com.ianbrandt.test.config

import com.ianbrandt.test.config.fx.TornadoFxConfig
import com.ianbrandt.test.service.AppService
import com.ianbrandt.test.service.AppServiceImpl
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import

@Configuration
@EnableAutoConfiguration
@Import(TornadoFxConfig::class)
internal class AppConfig {

	@Bean
	internal fun appService(): AppService {
		return AppServiceImpl()
	}
}
