package com.leohart.blinkytape;

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

/**
 * The base functionality of all BlinkyTapeControllers.  Even "Fake" ones need to work on arrays.
 * 
 * @author hartl
 *
 */
public abstract class BaseBlinkyTapeController implements BlinkyTapeController, AutoCloseable {

	private static final Log LOG = LogFactory.getLog(BaseBlinkyTapeController.class);


	public void renderFrames(BlinkyFrame[] frames) {
		this.renderFrames(frames, 0);
	}


	public void renderFrames(BlinkyFrame[] frames, long delayInMilliseconds) {
		frames.eachWithIndex { BlinkyFrame frame, int index ->
			LOG.info("Rendering Frame ${index}: ${frame}");

			if (frame != null){
				this.renderFrame(frame);

				try {
					Thread.sleep(delayInMilliseconds);
				} catch (Exception ex) {
					throw new BlinkyTapeControllerException("Problem sleeping thread: ", ex);
				}
			}
		}
	}
}