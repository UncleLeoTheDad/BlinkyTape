package com.leohart.blinkytape;

import java.awt.Color


/**
 * A class that helps you build a variety of different BlinkyTape frame patterns.
 * 
 * @author hartl
 *
 */
public class BlinkyFrameBuilder {
	
	private Integer withSpecificLight;

	private Color[] lights = new Color[BlinkyFrame.DEFAULT_LIGHT_COUNT];

	public BlinkyFrame build() {
		return new BlinkyFrame(lights);
	}

	public BlinkyFrameBuilder havingAnLightCountOf(Integer lightCount) {
		this.lights = new Color[lightCount];

		return this;
	}

	public BlinkyFrameBuilder withAllLightsSetTo(Color color) {
		this.setRangeToColor(0, lights.length - 1, color);

		return this;
	}
	
	public BlinkyFrameBuilder withSpecificLight(Integer specificLight){
		this.withSpecificLight = specificLight;
		
		return this;
	}
	
	public BlinkyFrameBuilder setToColor(Color color){
		this.lights[withSpecificLight] = color;
		
		return this;
	}
	
	public BlinkyFrameBuilder withSpecificLightsSetTo(Map<Integer, Color> lightToColorMappings){
		lightToColorMappings.each { Integer light, Color color -> 
			this.lights[light] = color;
		}
		
		return this;
	}

	private void checkThatStartAndEndAreWithinTheSizeOfTheFrame(int start, int end) {
		// Check the parameters
		if (start < 0 || start >= this.lights.length) {
			throw new IllegalArgumentException(
					"The start LED must be 0 or more and less than the number of LEDs.");
		}
		if (end < 0 || end >= this.lights.length) {
			throw new IllegalArgumentException(String.format(
					"The end LED must be 0 or more and less than the number of LEDs. It was %s",
					end));
		}
		if (start >= end) {
			throw new IllegalArgumentException("The end LED must be more than the start LED.");
		}
	}

	private void setRangeToColor(int start, int end, Color color) {
		this.checkThatStartAndEndAreWithinTheSizeOfTheFrame(start, end);

		// Set each light to the same color
		for (int light = start; light <= end; light++) {
			this.lights[light] = color;
		}
	}

}
