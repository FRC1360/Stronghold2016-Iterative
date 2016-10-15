package org.usfirst.frc.team1360.robot.auto.drive;

import org.usfirst.frc.team1360.robot.IO.RobotOutput;
import org.usfirst.frc.team1360.robot.auto.AutonCommand;
import org.usfirst.frc.team1360.robot.auto.RobotSubsystems;

public class DriveForward extends AutonCommand {

	private RobotOutput robotOutput;
	
	private double speed;
	
	public DriveForward(long timeout, double speed) {
		super(RobotSubsystems.DRIVE, timeout);
		
		this.robotOutput = RobotOutput.getInstance();
		this.speed = speed;
	}

	@Override
	public boolean calculate() {
		this.robotOutput.tankDrive(speed, speed);
		return false;
	}

	@Override
	public void override() {
		this.robotOutput.tankDrive(0, 0);
	}

}
