package com.leohart.blinkytape;

import groovy.transform.ToString;

import java.awt.Color;

/**
 * Represents a single "Frame" of a BlinkyTape, essentially the settings for all lights on the entire BlinkyTape (or chained BlinkyTapes) for a single "instant" or moment in time.
 * 
 * @author hartl
 *
 */
@ToString(includeNames=true, includeFields=true)
public class BlinkyFrame {

	public static final int DEFAULT_LIGHT_COUNT = 60;

	private Color[] lights;

	public BlinkyFrame() {
		this.lights = new Color[DEFAULT_LIGHT_COUNT];
	}

	public BlinkyFrame(int lightCount) {
		this.lights = new Color[lightCount];
	}

	public BlinkyFrame(Color[] lights) {
		this.lights = lights;
	}

	public Color getLight(Integer lightNumber) {
		return this.lights[lightNumber];
	}

	public Color[] getLights() {
		return this.lights;
	}

	public Integer getLightCount(){
		return this.lights.length;
	}

	public Color getColorOfLight(int light){
		return this.lights[light];
	}
}
