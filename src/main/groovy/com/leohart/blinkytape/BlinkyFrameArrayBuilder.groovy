package com.leohart.blinkytape;

import java.awt.Color
import java.awt.image.BufferedImage

import javax.imageio.ImageIO

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

/**
 * A builder that converts a Bitmap image to an array of BlinkyFrames where the X coordinate of the bitmap is mapped to frames and the Y coordinate to lights on the frame.  
 * Very similar to what Pattern Paint does and in fact, using Pattern Paint to create an image and this to load it is the targeted use case.
 *
 * @param url
 *
 */
class BlinkyFrameArrayBuilder {

	private static final Log LOG = LogFactory.getLog(BlinkyFrameArrayBuilder.class);

	private BlinkyFrame[] frames;


	public BlinkyFrameArrayBuilder withImage(URL url){
		BufferedImage image = ImageIO.read(url);

		frames = new BlinkyFrame[image.getWidth()];

		LOG.info("Converting image of (x:${image.getWidth()}, y:${image.getHeight()}) to BlinkyFrame[]...")

		for (int x=0; x<image.getWidth(); x++){
			BlinkyFrameBuilder builder = new BlinkyFrameBuilder();

			for (int y=0; y<image.getHeight(); y++){
				int rgba = image.getRGB(x, y);
				Color color = new Color(rgba, true);

				LOG.debug("Setting Light ${y} on BlinkyFrame ${x} to ${color}")

				builder.withSpecificLight(y).setToColor(color);
			}

			frames[x] = builder.build();
		}

		return this;
	}

	public BlinkyFrame[] build(){
		return frames;
	}
}
