package com.ianbrandt.test.config.fx

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import tornadofx.*

@Configuration
class TornadoFxConfig {

	@Autowired
	private lateinit var applicationContext: ApplicationContext

	@Bean
	fun springDIContainer(): SpringDIContainer {
		return SpringDIContainer(applicationContext)
	}

	@EventListener
	fun registerSpringDIContainerOn(event: ContextRefreshedEvent) {
		FX.dicontainer = springDIContainer()
	}
}
