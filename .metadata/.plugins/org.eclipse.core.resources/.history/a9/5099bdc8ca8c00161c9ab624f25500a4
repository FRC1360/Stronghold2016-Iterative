package org.usfirst.frc.team1360.robot.teleop;

import org.usfirst.frc.team1360.robot.IO.HumanInput;
import org.usfirst.frc.team1360.robot.IO.RobotOutput;

public class TeleopShoot implements TeleopComponent{

	private static TeleopShoot instance;
	private RobotOutput robotOutput;
	private HumanInput humanInput;
	
	private TeleopShoot()
	{
		this.robotOutput = robotOutput.getInstance();
		this.humanInput = humanInput.getInstance();	
	}
	
	public static TeleopShoot getInstance()
	{
		if(instance == null)
		{
			instance = new TeleopShoot();
		}
		return instance;
	}
	
	@Override
	public void calculate() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		
	}

}
