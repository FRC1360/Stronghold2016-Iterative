package org.usfirst.frc.team1360.robot.teleop;

import org.usfirst.frc.team1360.robot.IO.HumanInput;
import org.usfirst.frc.team1360.robot.IO.RobotOutput;

public class TeleopDrive implements TeleopComponent {
	
	private static TeleopDrive instance;
	private RobotOutput robotOutput;
	private HumanInput humanInput;
	
	public static TeleopDrive getInstance()
	{
		if(instance == null)
		{
			instance = new TeleopDrive();
		}
		
		return instance;
	}

	private TeleopDrive()
	{
		this.robotOutput = RobotOutput.getInstance();
		this.humanInput = HumanInput.getInstance();
	}
	
	public void calculate()
	{		
		double speed = this.humanInput.getDriverForward() - this.humanInput.getDriverBackward();
		double turn = this.humanInput.getDriverTurn();
		
		if(Math.abs(speed) < 0.1) speed = 0;
		if(Math.abs(turn) < 0.1) turn = 0;
		
		this.robotOutput.arcadeDrive(turn, speed);
		this.robotOutput.actuateDriveTrain(this.humanInput.getDriverActuate());
	}
	
	public void disable()
	{
		this.robotOutput.arcadeDrive(0, 0);
	}
	
}
