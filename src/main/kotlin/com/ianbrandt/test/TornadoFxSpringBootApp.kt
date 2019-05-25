package com.ianbrandt.test

import com.ianbrandt.test.config.AppConfig
import com.ianbrandt.test.view.AppView
import org.springframework.boot.SpringApplication
import tornadofx.*

fun main() {
	launch<TornadoFxSpringBootApp>()
}

class TornadoFxSpringBootApp : App(AppView::class) {

	override fun init() {
		super.init()
		SpringApplication.run(AppConfig::class.java)
	}
}
