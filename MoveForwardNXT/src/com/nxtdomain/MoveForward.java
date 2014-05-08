package com.nxtdomain;

import lejos.nxt.Motor;
import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.util.Delay;

public class MoveForward {

	public static void main(String[] args) {
		LCD.drawString("Assignment 1", 0, 0);
		Button.waitForAnyPress();
		Delay.msDelay(1500);
		LCD.clear();
		LCD.drawString("MOVING FORWARD",0,0);
        Motor.A.forward();
        Motor.C.forward();
        Delay.msDelay(3500);
        LCD.clear();
        Motor.A.stop(true);
        Motor.C.stop();
        LCD.drawString("STOPPED MOVING",0,0);
        Button.waitForAnyPress();
	}

}
