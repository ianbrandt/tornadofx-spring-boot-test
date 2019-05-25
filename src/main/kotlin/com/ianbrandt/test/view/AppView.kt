package com.ianbrandt.test.view

import com.ianbrandt.test.service.AppService
import tornadofx.*

class AppView : View("App View") {

	private val appService: AppService by di()

	override val root = vbox {
		button("Test") {
			id = "test-button"
			action {
				appService.doIt()
			}
		}
	}
}
