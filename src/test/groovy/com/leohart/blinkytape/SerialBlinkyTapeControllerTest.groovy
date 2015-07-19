package com.leohart.blinkytape;

import java.awt.Color

import org.junit.Test

public class SerialBlinkyTapeControllerTest {

	@Test
	public void testChangeColor() throws Exception {
		SerialBlinkyTapeController controller = new SerialBlinkyTapeController("COM6");

		Frame frame = new StaticFrame();
		frame.setAllToColor(Color.GREEN);
		controller.renderFrame(frame);

		Thread.sleep(1000);

		frame.setAllToColor(Color.RED);
		controller.renderFrame(frame);

		controller.close();
	}

	@Test
	public void testFadeColors() throws Exception {
		SerialBlinkyTapeController controller = new SerialBlinkyTapeController("COM6");

		Frame frame = new StaticFrame();

		20.times  {
			println "running"
			frame.setAllToFadeFromOneColorToAnother(Color.ORANGE, Color.RED);
			controller.renderFrame(frame);
			Thread.sleep(100);
			frame.setAllToFadeFromOneColorToAnother(Color.RED, Color.ORANGE);
			controller.renderFrame(frame);
			Thread.sleep(100);
			
		}
		controller.close();
	}

	@Test
	public void testIndiv() throws Exception {
		SerialBlinkyTapeController controller = new SerialBlinkyTapeController("COM6");

		Frame frame = new StaticFrame();


		Color[] colors = [Color.GREEN]*60;
		colors[5] = Color.RED;
		frame.setAllIndividually(colors);
		controller.renderFrame(frame);

		controller.close();
	}
}
