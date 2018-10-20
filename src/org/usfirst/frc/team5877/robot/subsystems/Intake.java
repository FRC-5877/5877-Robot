package org.usfirst.frc.team5877.robot.subsystems;

import org.usfirst.frc.team5877.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Intake extends Subsystem {

	private Spark sparkLeft;
	private Spark sparkRight;
	
	public Intake() {
		sparkLeft = new Spark(RobotMap.leftIntakeMotor);
		sparkRight = new Spark(RobotMap.rightIntakeMotor);
	}
	
	public void intakeBox(double speed) {
		sparkLeft.set(speed * -1);
		sparkRight.set(speed);
	}
	
	public void stopIntake() {
		sparkLeft.stopMotor();
		sparkRight.stopMotor();
	}
	
	public void spinBoxClockwise() {
		sparkLeft.set(.25);
		sparkRight.set(.75);
	}
	
	public void spinBoxCounterClockwise() {
		sparkLeft.set(.75 * -1);
		sparkRight.set(.25 * -1);
	}
	
	@Override
	protected void initDefaultCommand() {
	}

}
