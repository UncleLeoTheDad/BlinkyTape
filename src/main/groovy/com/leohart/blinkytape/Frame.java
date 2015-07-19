package com.leohart.blinkytape;

import java.awt.Color;

public interface Frame {

	int getLedCount();

	Color getColor(int led);

	void setOneToColor(int led, Color color);

	void setAllToColor(Color color);

	void setAllToFadeFromOneColorToAnother(Color startColor, Color endColor);

	public abstract void setAllIndividually(Color[] colors);

}
