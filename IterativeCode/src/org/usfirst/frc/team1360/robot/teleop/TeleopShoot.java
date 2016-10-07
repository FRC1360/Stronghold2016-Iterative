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
		
		double LSpeed = this.humanInput.getOperatorInatke() - this.humanInput.getOperatorOutake();
		double RSpeed = this.humanInput.getOperatorInatke() - this.humanInput.getOperatorOutake();
	
		if(Math.abs(LSpeed) > 0.3 || Math.abs(RSpeed) > 0.3)
		{
			this.robotOutput.setShooter(LSpeed, RSpeed);
		}
		else if(humanInput.getOperatorIntakeHeight())
		{
			this.robotOutput.setShooter(-1, -1);
		} 
		else if (humanInput.getOperatorBatterShot())
		{
			this.robotOutput.setShooter(0.5, 0.5);
		} 
		else if (humanInput.getOperatorOuterworksShot())
		{
			this.robotOutput.setShooter(1, 1);
		}
		
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		this.robotOutput.setShooter(0, 0);
	}

}
