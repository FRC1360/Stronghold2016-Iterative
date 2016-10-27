package org.usfirst.frc.team1360.robot.auto.mode.step1;

import org.usfirst.frc.team1360.robot.auto.drive.DriveForward;
import org.usfirst.frc.team1360.robot.auto.mode.AutonBuilder;
import org.usfirst.frc.team1360.robot.auto.mode.AutonMode;
import org.usfirst.frc.team1360.robot.auto.util.AutonWait;

public class JustDrive implements AutonMode {

	@Override
	public void addToMode(AutonBuilder ab) {
		// TODO Auto-generated method stub
		ab.addCommand(new DriveForward(3000, 0.75));
		ab.addCommand(new AutonWait(10000));
	}

}
