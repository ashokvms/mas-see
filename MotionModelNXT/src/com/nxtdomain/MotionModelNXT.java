package com.nxtdomain;

import lejos.nxt.Button;
import lejos.util.ButtonCounter;
import lejos.util.Delay;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class MotionModelNXT {
	
	DifferentialPilot pilot;
	ButtonCounter counter;

	public static void main(String[] args) {
		
		MotionModelNXT move = new MotionModelNXT();
		move.pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.C);
		
		move.pilot.setTravelSpeed(10);
		//move.pilot.setTravelSpeed(12);
		//move.pilot.setTravelSpeed(14);
		//move.pilot.setRotateSpeed(260);
		//move.pilot.setRotateSpeed(270);
		
		float distance = 20f;
		float orientation = 20f;
		
		LCD.drawString("Assignment 4", 0, 0);
		LCD.drawString("Press Button",0,1);
		Button.waitForAnyPress();
		
		LCD.clear();
		Delay.msDelay(1500);
		
		long startTime = System.nanoTime();

		LCD.drawString("Forward", 0, 0);
		move.moveForward(distance);

/*		LCD.drawString("Left Forward", 0, 0);
		move.moveArc(distance,orientation,"l");

		LCD.drawString("Right Forward", 0, 0);
		move.moveArc(distance,orientation,"r");*/

		long estimatedTime = System.nanoTime() - startTime;
		
		LCD.drawString("COMPLETED", 0, 1);
		LCD.drawString("Time "+Long.toString(estimatedTime),0,2);
		LCD.drawString("Press Button", 0, 7);
		Button.waitForAnyPress();
	}
	
	public void moveForward(float distance){
		pilot.travel(distance);
	}
	
	public void moveArc(float distance, float orientation, String direction){
		if(direction.equals("r"))
			orientation = -orientation;
		pilot.travelArc(orientation, distance);
	}

}

