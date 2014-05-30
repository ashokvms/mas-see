package com.nxtdomain;

import lejos.nxt.Button;
import lejos.nxt.LCD;
import lejos.util.Delay;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.nxt.Motor;

public class DiffForward {

	public static void main(String[] args) {
		DifferentialPilot pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.C);
		LCD.drawString("Assignment 1", 0, 0);
		LCD.drawString("Press Button",0,1);
		Button.waitForAnyPress();
		LCD.clear();
		LCD.drawString("DIFF FORWARD",0,0);
		Delay.msDelay(1500);
		//pilot.travel(20, true);
		pilot.forward();
		Delay.msDelay(3500);
		pilot.stop();
		LCD.drawString("STOPPED MOVING",0,0);
		LCD.drawString("Press Button",0,1);
		Button.waitForAnyPress();
	}

}
