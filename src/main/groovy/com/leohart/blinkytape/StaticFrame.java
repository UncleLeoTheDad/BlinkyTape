package com.leohart.blinkytape;

import java.awt.Color;

public class StaticFrame implements Frame {

	private static final int DEFAULT_LED_COUNT = 60;

	private int ledCount = DEFAULT_LED_COUNT;
	private Color[] leds;

	public StaticFrame() {
		this.leds = new Color[this.ledCount];
	}

	public StaticFrame(int ledCount) {
		this.ledCount = ledCount;
		this.leds = new Color[ledCount];
	}

	@Override
	public Color getColor(int led) {
		return this.leds[led];
	}

	@Override
	public int getLedCount() {
		return this.ledCount;
	}

	@Override
	public void setAllToColor(Color color) {
		this.setRangeToColor(0, this.getLedCount() - 1, color);
	}

	@Override
	public void setAllToFadeFromOneColorToAnother(Color startColor, Color endColor) {
		this.setRangeTofadeFromOneColorToAnother(0, this.getLedCount() - 1, startColor, endColor);
	}

	@Override
	public void setAllIndividually(Color[] colors) {
		if (colors.length > this.getLedCount()) {
			throw new IllegalArgumentException(
					"The array of colors must be of a size less than or equal to the number of LEDs.");
		}

		for (int i = 0; i < colors.length; i++) {
			setOneToColor(i, colors[i]);
		}
	}

	@Override
	public void setOneToColor(int led, Color color) {
		this.leds[led] = color;
	}

	public void setRangeToColor(int start, int end, Color color) {
		this.checkStartAndEndArguments(start, end);

		// Set all LEDs to the same color
		for (int led = start; led <= end; led++) {
			this.leds[led] = color;
		}
	}

	public void setRangeTofadeFromOneColorToAnother(int start, int end, Color startColor,
			Color endColor) {
		this.checkStartAndEndArguments(start, end);

		// Calculate the steps and the amount to change
		int steps = end - start;
		int redDelta = endColor.getRed() - startColor.getRed();
		float redStep = redDelta / (float) steps;
		int greenDelta = endColor.getGreen() - startColor.getGreen();
		float greenStep = greenDelta / (float) steps;
		int blueDelta = endColor.getBlue() - startColor.getBlue();
		float blueStep = blueDelta / (float) steps;

		float redRunning = startColor.getRed();
		float greenRunning = startColor.getGreen();
		float blueRunning = startColor.getBlue();

		// Fill in the range
		for (int led = start; led <= end; led++) {
			Color color = new Color((int) redRunning, (int) greenRunning, (int) blueRunning);
			this.leds[led] = color;

			redRunning += redStep;
			greenRunning += greenStep;
			blueRunning += blueStep;
		}
	}

	private void checkStartAndEndArguments(int start, int end) {
		// Check the parameters
		if (start < 0 || start >= this.ledCount) {
			throw new IllegalArgumentException(
					"The start LED must be 0 or more and less than the number of LEDs.");
		}
		if (end < 0 || end >= this.ledCount) {
			throw new IllegalArgumentException(String.format(
					"The end LED must be 0 or more and less than the number of LEDs. It was %s",
					end));
		}
		if (start >= end) {
			throw new IllegalArgumentException("The end LED must be more than the start LED.");
		}
	}
	
	public Frame[] setAllToLoop(){
		return null;
	}

}
