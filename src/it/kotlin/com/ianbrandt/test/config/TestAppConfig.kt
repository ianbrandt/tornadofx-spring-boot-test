package com.ianbrandt.test.config

import com.ianbrandt.test.config.fx.TornadoFxConfig
import com.ianbrandt.test.service.AppService
import com.ianbrandt.test.service.TestAppServiceImpl
import org.springframework.boot.SpringBootConfiguration
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import

@SpringBootConfiguration
@EnableAutoConfiguration
@Import(TornadoFxConfig::class)
class TestAppConfig {

	@Bean
	internal fun appService(): AppService {
		return TestAppServiceImpl()
	}
}
