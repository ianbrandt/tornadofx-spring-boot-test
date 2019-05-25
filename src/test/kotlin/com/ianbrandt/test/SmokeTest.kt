package com.ianbrandt.test

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SmokeTest {

	@Test
	fun `test for smoke`() {
		assertThat(true).isTrue()
	}
}
