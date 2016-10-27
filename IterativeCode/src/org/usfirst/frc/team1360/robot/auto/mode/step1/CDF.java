package org.usfirst.frc.team1360.robot.auto.mode.step1;

import org.usfirst.frc.team1360.robot.auto.drive.DriveForward;
import org.usfirst.frc.team1360.robot.auto.drive.DriveWait;
import org.usfirst.frc.team1360.robot.auto.mode.AutonBuilder;
import org.usfirst.frc.team1360.robot.auto.mode.AutonMode;
import org.usfirst.frc.team1360.robot.auto.pivot.PivotPID;
import org.usfirst.frc.team1360.robot.auto.util.AutonWait;

public class CDF implements AutonMode{

	@Override
	public void addToMode(AutonBuilder ab) {
		// TODO Auto-generated method stub
		ab.addCommand(new DriveForward(1000, -0.5));
		ab.addCommand(new DriveWait());
		ab.addCommand(new PivotPID(30));
		ab.addCommand(new AutonWait(1000));
		ab.addCommand(new DriveForward(1000, -0.5));
	}

}
