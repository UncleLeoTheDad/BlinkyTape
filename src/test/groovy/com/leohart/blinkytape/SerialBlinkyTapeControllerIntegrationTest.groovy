package com.leohart.blinkytape;

import java.awt.Color

import org.junit.After
import org.junit.Before
import org.junit.Ignore
import org.junit.Test

/**
 * @author hartl
 * 
 * By default this test is ignored as it reached a physical BlinkyTape to be attached.  This is useful as a "smoke test" for the hardware/software connection.
 *
 */
@Ignore
public class SerialBlinkyTapeControllerIntegrationTest {

	private static final String SERIAL_PORT_FOR_BLINKY_TAPE = TestConstants.DEFAULT_COM_PORT;
	
	SerialBlinkyTapeController controller;

	@Before
	public void initializeController(){
		controller = new SerialBlinkyTapeController(SERIAL_PORT_FOR_BLINKY_TAPE);
	}

	@After
	public void closeController(){
		controller.close();
	}

	@Test
	public void shouldBeAbleToChangeAllLightsToASingleColor(){
		BlinkyFrame frame = new BlinkyFrameBuilder().withAllLightsSetTo(Color.BLUE)
				.build();

		controller.renderFrame(frame);

		//No meaningful way to assert other than visual confirmation
	}
}
