package org.usfirst.frc.team5877.robot.subsystems;

import org.usfirst.frc.team5877.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;


public class DriveTrain extends Subsystem {

	private WPI_TalonSRX rightTalon1, rightTalon2, leftTalon1, leftTalon2;
	private DifferentialDrive drive;
	
	public DriveTrain() {
		rightTalon1 = new WPI_TalonSRX(RobotMap.rightMotor1);
		rightTalon2 = new WPI_TalonSRX(RobotMap.rightMotor2);
		leftTalon1 = new WPI_TalonSRX(RobotMap.leftMotor1);
		leftTalon2 = new WPI_TalonSRX(RobotMap.leftMotor2);
		
		SpeedControllerGroup leftMotors = new SpeedControllerGroup(leftTalon1, leftTalon2);
		SpeedControllerGroup rightMotors = new SpeedControllerGroup(rightTalon1, rightTalon2);
		
		//TODO: change to correct left, right params
		drive = new DifferentialDrive(rightMotors, leftMotors);		
	}
	
	// TODO: change to proper naming
	public void arcadeDrive(double speed, double rotation) {
		drive.curvatureDrive(speed, rotation, true);
	}
	
	@Override
	protected void initDefaultCommand() {
	}

}
