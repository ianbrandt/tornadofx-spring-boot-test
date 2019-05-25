package com.ianbrandt.test

import com.ianbrandt.test.config.AppConfig
import com.ianbrandt.test.view.AppView
import org.springframework.boot.SpringApplication
import tornadofx.*

class TornadoFxSpringBootApp : App(AppView::class) {

	override fun init() {
		super.init()
		SpringApplication.run(AppConfig::class.java)
	}
}
