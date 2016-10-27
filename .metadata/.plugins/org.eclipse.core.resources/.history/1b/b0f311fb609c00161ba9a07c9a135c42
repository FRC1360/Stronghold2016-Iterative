package org.usfirst.frc.team1360.robot.auto.drive;

import org.usfirst.frc.team1360.robot.IO.RobotOutput;
import org.usfirst.frc.team1360.robot.auto.AutonCommand;
import org.usfirst.frc.team1360.robot.auto.RobotSubsystems;

public class ActivateSolenoid extends AutonCommand {

	private RobotOutput robotOutput;
	private boolean state;
	
	public ActivateSolenoid(boolean state) {
		super(RobotSubsystems.DRIVE);
		
		robotOutput = RobotOutput.getInstance();
		this.state = state;
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean calculate() {
		this.robotOutput.actuateDriveTrain(state);
		return false;
	}

	@Override
	public void override() {
		// TODO Auto-generated method stub
		
	}

}
