package org.usfirst.frc.team5877.robot.commands;

import org.usfirst.frc.team5877.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;


public class IntakeCommand extends Command {

	private enum IntakeStatus {
		idle,
		spinClockwise,
		spinCounterClockwise,
		otherCommandRunning
	}
	
	private IntakeStatus status = IntakeStatus.idle;
  
    public IntakeCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.intake);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	if (Robot.oi.getJoy2RightTrigger() != 0 && status != IntakeStatus.spinClockwise) {
        	Robot.intake.spinBoxClockwise();
        	status = IntakeStatus.spinClockwise;
    	} else if (Robot.oi.getJoy2LeftTrigger() != 0 && status != IntakeStatus.spinCounterClockwise) {
    		Robot.intake.spinBoxCounterClockwise();
    		status = IntakeStatus.spinCounterClockwise;
    	} else if (Robot.oi.getJoy2RightTrigger() == 0 && Robot.oi.getJoy2RightTrigger() == 0 && status != IntakeStatus.idle) {
    		Robot.intake.stopIntake();
    		status = IntakeStatus.idle;
    	}
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	status = IntakeStatus.otherCommandRunning;
    }
}
