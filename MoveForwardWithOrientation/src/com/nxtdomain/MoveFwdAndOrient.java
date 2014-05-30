package com.nxtdomain;

import lejos.nxt.Button;
import lejos.util.ButtonCounter;
import lejos.util.Delay;
import lejos.nxt.LCD;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class MoveFwdAndOrient {
	
	DifferentialPilot pilot;
	ButtonCounter counter;

	public static void main(String[] args) {
		
		MoveFwdAndOrient move = new MoveFwdAndOrient();
		move.pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.C);
		move.counter = new ButtonCounter();
		float distance = 20f;
		float orientation = 20f;
		LCD.drawString("Assignment 3", 0, 0);
		LCD.drawString("Press Button",0,1);
		Button.waitForAnyPress();
		LCD.clear();
		String selection = move.userInput();
		LCD.clear();
		switch(selection){
		case "R1":
			LCD.drawString("Forward Short", 0, 0);
			Delay.msDelay(1500);
			move.moveForward(0.7f*distance);
			break;
		case "R2":
			LCD.drawString("Forward", 0, 0);
			Delay.msDelay(1500);
			move.moveForward(distance);
			break;
		case "R3":
			LCD.drawString("Forward Long", 0, 0);
			Delay.msDelay(1500);
			move.moveForward(1.5f*distance);
			break;
		case "L1":
			LCD.drawString("Left Short", 0, 0);
			Delay.msDelay(1500);
			move.moveArc(0.8f*distance,0.4f*orientation,"l");
			break;
		case "L2":
			LCD.drawString("Left Forward", 0, 0);
			Delay.msDelay(1500);
			move.moveArc(distance,orientation,"l");
			break;
		case "L3":
			LCD.drawString("Right Short", 0, 0);
			Delay.msDelay(1500);
			move.moveArc(0.8f*distance,0.4f*orientation,"r");
			break;
		case "L4":
			LCD.drawString("Right Forward", 0, 0);
			Delay.msDelay(1500);
			move.moveArc(distance,orientation,"r");
			break;
		default:
			LCD.drawString("Forward", 0, 0);
			Delay.msDelay(1500);
			move.moveForward(distance);
			break;
		}
		LCD.clear();
		LCD.drawString("COMPLETED", 0, 0);
		LCD.drawString("Press Button", 0, 1);
		Button.waitForAnyPress();
	}
	
	public String userInput(){
		counter.count("\n\n"
				+ "Press L/R Button\n"
				+ "R1-FS;R2-F;R3-FL\n"
				+ "L1-LS;L2-L\n"
				+ "L3-RS;L4-R\n"
				+ "Select and Exit");
		int left = counter.getLeftCount();
		int right = counter.getRightCount();
		if(right>=left)
			return "R"+Integer.toString(right);
		else
			return "L"+Integer.toString(left);
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
