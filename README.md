# BlinkyTape
Java/Groovy implementation of a controller for the BlinkyTape device (http://blinkinlabs.com/blinkytape/).  

The tests demonstrate how to use the library:
https://github.com/leojhartiv/BlinkyTape/tree/master/src/test/groovy/com/leohart/blinkytape

This test, when un-@Ignored, should provide a "smoke test" of your BlinkyTape integration:
https://github.com/leojhartiv/BlinkyTape/blob/master/src/test/groovy/com/leohart/blinkytape/SerialBlinkyTapeControllerIntegrationTest.groovy

# Major concepts:
* BlinkyTapeController: a wrapper around the BlinkyTape USB/serial port interface.  Allows you to render one or more "BlinkyFrames"
* BlinkyFrame:  represents a standard BlinkyTape light strip at a given moment in time
* BlinkyFrameBuilder: helper class that allows you to easily build single BlinkyFrame with all lights or specific lights set to the specified colors.
* BlinkyFrameArrayBuilder: helper class that allows you to build a pattern from an image (BMP, PNG, etc) file.  This is very similar to what PatternPaint (http://blinkinlabs.com/blinkytape/patternpaint/) provides a UI for.  In fact, the primary use case I built this for includes exporting images from Paint or "Pattern Paint" and loading it into this library.

# Known Usage:
I built this library in order to tie BlinkyTape into my company's Continuous Integration environment via the build-whisperer project I created a while back here:
  https://github.com/leojhartiv/build-whisperer
There is a simple BlinkyTape implementation provided that allows you to connect Jenkins, Bamboo or any other REST/JSON based page up to the BlinkyTape.

# Links:
* The project's Continous Integration server: https://snap-ci.com/leojhartiv/BlinkyTape

[![](https://codescene.io/projects/1214/status.svg) Get more details at **codescene.io**.](https://codescene.io/projects/1214/jobs/latest-successful/results)
