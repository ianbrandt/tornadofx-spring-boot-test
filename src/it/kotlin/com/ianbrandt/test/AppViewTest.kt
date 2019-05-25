package com.ianbrandt.test

import com.ianbrandt.test.config.TestAppConfig
import com.ianbrandt.test.view.AppView
import javafx.scene.Scene
import javafx.stage.Stage
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.testfx.api.FxRobot
import org.testfx.framework.junit5.ApplicationExtension
import org.testfx.framework.junit5.Start

@SpringBootTest(classes = [TestAppConfig::class])
@ExtendWith(SpringExtension::class, ApplicationExtension::class)
class AppViewTest {

	@Start
	fun start(stage: Stage) {
		stage.scene = Scene(AppView().root)
		stage.show()
	}

	@Test
	fun `test the button`(robot: FxRobot) {
		println("TESTING...")
		robot.clickOn("#test-button")
	}
}
