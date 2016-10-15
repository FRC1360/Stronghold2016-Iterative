package org.usfirst.frc.team1360.robot.auto.drive;

import org.usfirst.frc.team1360.robot.auto.AutonCommand;
import org.usfirst.frc.team1360.robot.auto.RobotSubsystems;

public class DriveWait extends AutonCommand {
	public DriveWait() {
		super(RobotSubsystems.DRIVE);
	}

	@Override
	public boolean calculate() {
		return true;
	}

	@Override
	public void override() {
		
		
	}
}
