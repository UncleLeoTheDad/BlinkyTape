package com.leohart.blinkytape;

/**
 * The interface which must be satisfied to do basic BlinkyFrame manipulation.
 * Supports the delivery of a single frame, multiple frames and multiple frames
 * with delays.
 * 
 * Note: you do need to be mindful of closing the controller when done or you're
 * get "port in use" exceptions.
 * 
 * @author hartl
 *
 */
public interface BlinkyTapeController {

	void renderFrame(BlinkyFrame frame);

	void renderFrames(BlinkyFrame[] frames);

	void renderFrames(BlinkyFrame[] frames, long delayInMilliseconds);

	void close();

}
