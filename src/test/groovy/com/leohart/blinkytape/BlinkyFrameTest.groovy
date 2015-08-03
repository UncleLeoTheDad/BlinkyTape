package com.leohart.blinkytape;

import static org.junit.Assert.*

import org.junit.Assert
import org.junit.Test

class BlinkyFrameTest {

	@Test
	public void shouldBeAbleToCreateAFrameWithAnyNumberOfBlinkyLights() {
		final Integer EXPECTED_LIGHT_COUNT = 2;
		
		BlinkyFrame frame = new BlinkyFrame(2);
		
		Assert.assertEquals("Should have been ${EXPECTED_LIGHT_COUNT} lights: ", EXPECTED_LIGHT_COUNT, frame.getLightCount());
	}

}
