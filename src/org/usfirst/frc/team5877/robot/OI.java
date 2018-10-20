/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5877.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	private XboxController controller1;
	private XboxController controller2;
	private Button controller1RightBumper;
	private Button controller2AButton;
	private Button controller2BButton;
	private Button controller2LeftBumper;
	private Button controller2RightBumper;
	
	private double deadZone = .15d;
	
	public OI() {
		controller1 = new XboxController(0);
		controller1RightBumper = new JoystickButton(controller1, 6);
		
		controller2 = new XboxController(1);
		controller2AButton = new JoystickButton(controller2, 1);
		controller2BButton = new JoystickButton(controller2, 2);
		controller2LeftBumper = new JoystickButton(controller2, 5);
		controller2RightBumper = new JoystickButton(controller2, 6);
	}
	
	public XboxController getJoy1() {
		return controller1;
	}
	
	public XboxController getJoy2() {
		return controller2;
	}
	
	public Button getJoy1RightBumper() {
		return controller1RightBumper;
	}
	
	public double getJoy1LeftStickYAxis() {
		if (Math.abs(controller1.getY(Hand.kLeft)) > deadZone) {
			return controller1.getY(Hand.kLeft);
		} else {
			return 0;
		}
	}
	
	public double getJoy1RightStickXAxis() {
		if (Math.abs(controller1.getX(Hand.kRight)) > deadZone) {
			return controller1.getX(Hand.kRight);
		} else {
			return 0;
		}
	}
	
	public double getJoy2LeftStickYAxis() {
		if (Math.abs(controller2.getY(Hand.kLeft)) > deadZone) {
			return controller2.getY(Hand.kLeft);
		} else {
			return 0;
		}
	}
	
	public Button getJoy2ButtonA() {
		return controller2AButton;
	}
	
	public Button getJoy2ButtonB() {
		return controller2BButton;
	}
	
	public Button getJoy2LeftBumper() {
		return controller2LeftBumper;
	}
	
	public Button getJoy2RightBumper() {
		return controller2RightBumper;
	}
	
	public double getJoy2LeftTrigger() {
		if (Math.abs(controller2.getTriggerAxis(Hand.kLeft)) > deadZone) {
			return controller2.getTriggerAxis(Hand.kLeft);
		} else {
			return 0;
		}
	}
	
	public double getJoy2RightTrigger() {
		if (Math.abs(controller2.getTriggerAxis(Hand.kRight)) > deadZone) {
			return controller2.getTriggerAxis(Hand.kRight);
		} else {
			return 0;
		}
	}
	
	//// CREATING BUTTONS
	// One type of button is a joystick button which is any button on a
	//// joystick.
	// You create one by telling it which joystick it's on and which button
	// number it is.
	// Joystick stick = new Joystick(port);
	// Button button = new JoystickButton(stick, buttonNumber);

	// There are a few additional built in buttons you can use. Additionally,
	// by subclassing Button you can create custom triggers and bind those to
	// commands the same as any other Button.

	//// TRIGGERING COMMANDS WITH BUTTONS
	// Once you have a button, it's trivial to bind it to a button in one of
	// three ways:

	// Start the command when the button is pressed and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenPressed(new ExampleCommand());

	// Run the command while the button is being held down and interrupt it once
	// the button is released.
	// button.whileHeld(new ExampleCommand());

	// Start the command when the button is released and let it run the command
	// until it is finished as determined by it's isFinished method.
	// button.whenReleased(new ExampleCommand());
}
