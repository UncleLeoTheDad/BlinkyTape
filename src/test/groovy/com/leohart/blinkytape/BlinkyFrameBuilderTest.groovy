package com.leohart.blinkytape;

import static org.junit.Assert.*

import java.awt.Color

import org.junit.Assert
import org.junit.Test

class BlinkyFrameBuilderTest {

	@Test
	public void shouldBeAbleToCreateFrameWhereAllLightsAreASingleColor() {
		BlinkyFrame frame = new BlinkyFrameBuilder().withAllLightsSetTo(Color.BLUE)
				.build();

		frame.lights.eachWithIndex {Color light, int lightNumber ->
			Assert.assertEquals("Light ${lightNumber} should have been ${Color.BLUE}: ", light, Color.BLUE); 
		}
	}
	
	@Test
	public void shouldBeAbleToSetASpecificLightToAColor() {
		final int EXPECTED_LIGHT = 1;
		final Color EXPECTED_COLOR = Color.BLUE;
		BlinkyFrame frame = new BlinkyFrameBuilder().withSpecificLight(EXPECTED_LIGHT).setToColor(EXPECTED_COLOR)
													.build();

		Assert.assertEquals("Light was not correctly colored: ", EXPECTED_COLOR, frame.getLight(EXPECTED_LIGHT));
	}
	
	@Test
	public void shouldBeAbleToSpecifyNumberOfLights() {
		final int EXPECTED_NUMBER_OF_LIGHTS = 2;
		BlinkyFrame frame = new BlinkyFrameBuilder().havingAnLightCountOf(EXPECTED_NUMBER_OF_LIGHTS)
													.build();

		Assert.assertEquals("Unexpected number of lights: ", EXPECTED_NUMBER_OF_LIGHTS, frame.getLightCount());
	}
	
	@Test 
	public	void shouldBeAbleToSetVariousLightsToVariousColorsAtOnce(){
		final int FIRST_LIGHT = 5
		final Color FIRST_LIGHT_COLOR = Color.RED;
		
		final int SECOND_LIGHT = 10
		final Color SECOND_LIGHT_COLOR = Color.BLUE;
		
		Map<Integer, Color> lights = [(FIRST_LIGHT):FIRST_LIGHT_COLOR, 
									  (SECOND_LIGHT):SECOND_LIGHT_COLOR];
		
		BlinkyFrame frame = new BlinkyFrameBuilder().withSpecificLightsSetTo(lights)
													.build();
													
		Assert.assertEquals("Light ${FIRST_LIGHT} was not correctly colored: ", FIRST_LIGHT_COLOR, frame.getColorOfLight(FIRST_LIGHT));
		Assert.assertEquals("Light ${SECOND_LIGHT} was not correctly colored: ", SECOND_LIGHT_COLOR, frame.getColorOfLight(SECOND_LIGHT));
	}

}
