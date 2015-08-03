package com.leohart.blinkytape;

import static org.junit.Assert.*

import java.awt.Color

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory
import org.junit.Assert
import org.junit.Test


class BlinkyFrameArrayBuilderTest {

	private static final Log LOG = LogFactory.getLog(BlinkyFrameArrayBuilderTest.class);
	
	private static final Integer IMAGE_WIDTH = 60;
	private static final Integer IMAGE_HEIGHT = 60;

	@Test
	public void shouldBeAbleToReadABitmapAndGenerateAFrameArray() {
		URL url = this.getClass().getResource("/com/leohart/blinkytape/ExamplePattern.png");

		BlinkyFrame[] frames = new BlinkyFrameArrayBuilder().withImage(url)
				.build();

		for (int x=0; x<IMAGE_WIDTH; x++){
			for (int y=0; y<IMAGE_HEIGHT; y++){
				LOG.info("Looking at frame ${x} and light ${y}...")
				if (x==y){
					Assert.assertEquals("Light ${y} on frame ${x} should have been white: ", Color.WHITE, frames[x].getLight(y));
				}
				else{
					Assert.assertEquals("Light ${y} on frame ${x} should have been black: ", Color.BLACK, frames[x].getLight(y));
				}
			}
		}
	}
}
