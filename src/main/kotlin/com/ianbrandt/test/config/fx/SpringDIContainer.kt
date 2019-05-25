package com.ianbrandt.test.config.fx

import org.springframework.context.ApplicationContext
import tornadofx.*
import javax.inject.Inject
import kotlin.reflect.KClass

class SpringDIContainer(@Inject private val applicationContext: ApplicationContext) : DIContainer {

	override fun <T : Any> getInstance(type: KClass<T>): T = applicationContext.getBean(type.java)

	override fun <T : Any> getInstance(type: KClass<T>, name: String): T =
		applicationContext.getBean(name, type.java)
}
