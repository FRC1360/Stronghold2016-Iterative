package org.usfirst.frc.team1360.robot.auto.mode.step1;

import org.usfirst.frc.team1360.robot.auto.drive.ActivateSolenoid;
import org.usfirst.frc.team1360.robot.auto.drive.DriveForward;
import org.usfirst.frc.team1360.robot.auto.mode.AutonBuilder;
import org.usfirst.frc.team1360.robot.auto.mode.AutonMode;
import org.usfirst.frc.team1360.robot.auto.util.AutonWait;

public class DriveWithActuate implements AutonMode {

	@Override
	public void addToMode(AutonBuilder ab) {
		ab.addCommand(new ActivateSolenoid(true));
		ab.addCommand(new DriveForward(3000, 0.5));
		ab.addCommand(new AutonWait(10000));
	}

}
