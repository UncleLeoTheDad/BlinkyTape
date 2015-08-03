package com.leohart.blinkytape;

import org.apache.commons.logging.Log
import org.apache.commons.logging.LogFactory

public class FakeBlinkyTapeController extends BaseBlinkyTapeController {

	private static final Log LOG = LogFactory.getLog(FakeBlinkyTapeController.class);
	
	private Boolean closed;

	private ArrayList<BlinkyFrame> framesRendered = new ArrayList<BlinkyFrame>();

	public FakeBlinkyTapeController() {
		super();
		this.closed = false;
	}

	@Override
	public void close() {
		this.closed = true;
	}

	public ArrayList<BlinkyFrame> getFramesRendered() {
		return framesRendered;
	}

	@Override
	public void renderFrame(BlinkyFrame frame) {
		LOG.info("Rendering frame ${frame}");
		
		this.framesRendered.add(frame);
	}

}