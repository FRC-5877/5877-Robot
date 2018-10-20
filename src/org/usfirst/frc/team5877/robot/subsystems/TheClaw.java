package org.usfirst.frc.team5877.robot.subsystems;

import org.usfirst.frc.team5877.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class TheClaw extends Subsystem {

	private WPI_TalonSRX clawTalon;
	
	public TheClaw() {
		clawTalon = new WPI_TalonSRX(RobotMap.clawMotor);	
		clawTalon.setInverted(true);
		//clawTalon.configClosedloopRamp(4, 0);
		//clawTalon.configOpenloopRamp(4, 0);
	}
	
	public void moveClaw(double speed) {
		double rateLimit = .1;
		double currentSpeed = clawTalon.get();
		
		if (speed - currentSpeed > rateLimit) {
			speed = currentSpeed + rateLimit;
		} else if (currentSpeed - speed > rateLimit) {
			speed = currentSpeed - rateLimit;
		}

		clawTalon.set(speed);
	}
	
	@Override
	protected void initDefaultCommand() {
	}

}
