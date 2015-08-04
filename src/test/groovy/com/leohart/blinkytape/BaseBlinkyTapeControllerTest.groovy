package com.leohart.blinkytape;

import java.awt.Color

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

public class BaseBlinkyTapeControllerTest {

	FakeBlinkyTapeController controller;

	@Before
	public void initializeController(){
		controller = new FakeBlinkyTapeController();
	}

	@After
	public void closeController(){
		controller.close();
	}
 
	@Test
	public void shouldBeAbleToChangeAllLightsToASingleColor(){
		BlinkyFrame frame = new BlinkyFrameBuilder().withAllLightsSetTo(Color.BLUE)
				.build();

		controller.renderFrame(frame);

		Assert.assertEquals("Should have rendered frame: ", frame, controller.getFramesRendered().last());
	}

	@Test
	public void shouldBeAbleToSendMultipleFramesToFormAPattern(){
		BlinkyFrame[] frames = new BlinkyFrame[2];

		frames[0] = new BlinkyFrameBuilder().withAllLightsSetTo(Color.BLUE)
											.build();
		frames[1] = new BlinkyFrameBuilder().withAllLightsSetTo(Color.MAGENTA)
											.build();

		controller.renderFrames(frames);
		
		Assert.assertEquals("Should have rendered ${frames[0]} frame first: ", frames[0], controller.getFramesRendered()[0]);
		Assert.assertEquals("Should have rendered ${frames[1]} frame second: ", frames[1], controller.getFramesRendered()[1]);
	}

	@Test
	public void shouldSkipEmptyFrames(){
		BlinkyFrame[] frames = new BlinkyFrame[2];

		controller.renderFrames(frames);
		
		Assert.assertEquals("Should have rendered 0 frames: ", 0, controller.getFramesRendered().size());
	}
	
	@Test(expected=BlinkyTapeControllerException.class)
	public void shouldWrapThreadRelatedExceptions(){
		BlinkyFrame[] frames = new BlinkyFrame[2];
		frames[0] = new BlinkyFrame();
		frames[0] = new BlinkyFrame();

		controller.renderFrames(frames, -1);				
	}

}
