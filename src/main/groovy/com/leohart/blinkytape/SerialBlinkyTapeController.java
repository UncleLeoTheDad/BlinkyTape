package com.leohart.blinkytape;

import jssc.SerialPort;
import jssc.SerialPortException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class SerialBlinkyTapeController implements AutoCloseable {

	private static final Log LOG = LogFactory.getLog(SerialBlinkyTapeController.class);
	private static final int DEFAULT_LED_COUNT = 60;

	private SerialPort serialPort;
	private int ledCount = DEFAULT_LED_COUNT;

	public SerialBlinkyTapeController(String portName, int ledCount) {
		this(portName);
		this.ledCount = ledCount;
	}

	public SerialBlinkyTapeController(String portName) {
		super();
		this.serialPort = new SerialPort(portName);
		try {
			this.serialPort.openPort();

			serialPort.setParams(SerialPort.BAUDRATE_115200, SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);

		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void renderFrame(Frame frame) {
		// Creates an array big enough to hold each LED color and the
		// terminator.
		byte[] data = new byte[(frame.getLedCount() + 1) * 3];
		int offset;
		for (int led = 0; led < frame.getLedCount(); led++) {
			// 3 bytes, RGB, limited to a maximum of 254 as 255 is special.
			offset = led * 3;
			data[offset] = (byte) Math.min(frame.getColor(led).getRed(), 254);
			data[offset + 1] = (byte) Math.min(frame.getColor(led).getGreen(), 254);
			data[offset + 2] = (byte) Math.min(frame.getColor(led).getBlue(), 254);
		}

		// The sketch only reads three bytes at a time so send 3 with the final
		// 0xFF
		offset = frame.getLedCount() * 3;
		data[offset] = 0x0;
		data[offset + 1] = 0x0;
		data[offset + 2] = (byte) 0xFF;

		try {
			this.serialPort.writeBytes(data);
		} catch (SerialPortException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void close() throws Exception {
		this.serialPort.closePort();
	}

}