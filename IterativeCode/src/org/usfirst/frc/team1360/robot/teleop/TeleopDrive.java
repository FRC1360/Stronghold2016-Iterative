package org.usfirst.frc.team1360.robot.teleop;

import org.usfirst.frc.team1360.robot.IO.HumanInput;
import org.usfirst.frc.team1360.robot.IO.RobotOutput;

public class TeleopDrive implements TeleopComponent { // Component that controls the drive

	private static TeleopDrive instance; // Current instance of singleton
	private RobotOutput robotOutput; // Motor outputs
	private HumanInput humanInput; // Driver inputs

	public static TeleopDrive getInstance() // Gets current instance of the singleton, initializes if inecessary
	{
		if(instance == null)
		{
			instance = new TeleopDrive();
		}

		return instance;
	}

	private TeleopDrive() // Basic default constructor, populates fields
	{
		this.robotOutput = RobotOutput.getInstance();
		this.humanInput = HumanInput.getInstance();
	}

	public void calculate() // Updates the motors from the driver input, including handling deadzones
	{
		double speed = this.humanInput.getDriverForward() - this.humanInput.getDriverBackward();
		double turn = this.humanInput.getDriverTurn();

		if(Math.abs(speed) < 0.1) speed = 0;
		if(Math.abs(turn) < 0.1) turn = 0;

		this.robotOutput.arcadeDrive(turn, speed);
		this.robotOutput.actuateDriveTrain(this.humanInput.getDriverActuate());
	}

	public void disable() // Ensures that motors are turned off
	{
		this.robotOutput.arcadeDrive(0, 0);
	}

}
