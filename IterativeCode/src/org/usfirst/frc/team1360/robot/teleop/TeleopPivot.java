package org.usfirst.frc.team1360.robot.teleop;

import org.usfirst.frc.team1360.robot.IO.HumanInput;
import org.usfirst.frc.team1360.robot.IO.RobotOutput;
import org.usfirst.frc.team1360.robot.IO.SensorInput;
import org.usfirst.frc.team1360.robot.util.pid.OrbitPID;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleopPivot implements TeleopComponent { // Component that controls the pivot

	private static TeleopPivot instance; // Current instance of singleton
	private RobotOutput robotOutput; // Motor outputs
	private HumanInput humanInput; // Driver inputs
	private SensorInput sensorInput; // Sensor inputs

	private OrbitPID pivotController; // PID controller

	private TeleopPivot() // Default constructor, populates fields, sets up PID, and displays PID configuration to SmartDashboard
	{
		this.robotOutput = RobotOutput.getInstance();
		this.humanInput = HumanInput.getInstance();
		this.sensorInput = SensorInput.getInstance();
		this.pivotController =  new OrbitPID(0.35, 0.001, 0.01, 0.5);
		SmartDashboard.putNumber("Pivot P: ", 0.35);
		SmartDashboard.putNumber("Pivot I: ", 0.001);
		SmartDashboard.putNumber("Pivot D: ", 0.01);
		SmartDashboard.putNumber("Pivot Eps: ", 0.5);
	}

	public static TeleopPivot getInstance() // Gets current instance of the singletotn, initializes if necessary
	{
		if(instance == null)
		{
			instance = new TeleopPivot();
		}

		return instance;
	}

	@Override
	public void calculate() { // Runs PID and updates motors from controller, adjusting target if possible
		this.pivotController.SetP(SmartDashboard.getNumber("Pivot P: "));
		this.pivotController.SetI(SmartDashboard.getNumber("Pivot I: "));
		this.pivotController.SetD(SmartDashboard.getNumber("Pivot D: "));
		this.pivotController.SetEps(SmartDashboard.getNumber("Pivot Eps: "));

		double speed = this.humanInput.getOperatorPivot();
		this.pivotController.SetInput(this.sensorInput.getPivotEncoderDegrees());

		if(Math.abs(speed) > 0.2)
		{
			robotOutput.pivot(speed);
			this.pivotController.SetSetpoint(-1);
			this.pivotController.CalculateError();
		}
		else if (humanInput.getOperatorIntakeHeight())
		{
			this.pivotController.SetSetpoint(0);
			this.pivotController.CalculateError();
			this.robotOutput.pivot(this.pivotController.GetOutput());
		}
		else if (humanInput.getOperatorShoot())
		{
			this.pivotController.SetSetpoint(125);
			this.pivotController.CalculateError();
			this.robotOutput.pivot(this.pivotController.GetOutput());

		}
		else if (humanInput.getOperatorUpPosition())
		{
			this.pivotController.SetSetpoint(145);
			this.pivotController.CalculateError();
			this.robotOutput.pivot(this.pivotController.GetOutput());

		}
		else if (humanInput.getOperatorLowgoal())
		{
			this.pivotController.SetSetpoint(20);
			this.pivotController.CalculateError();
			this.robotOutput.pivot(this.pivotController.GetOutput());
		}
		else if (humanInput.getOperatorShootPosition())
		{
			this.pivotController.SetSetpoint(125);
			this.pivotController.CalculateError();
			this.robotOutput.pivot(this.pivotController.GetOutput());
		}
		else
		{
			robotOutput.pivot(0);
			this.pivotController.SetSetpoint(-1);
			this.pivotController.CalculateError();
		}

	}

	@Override
	public void disable() { // Ensures that motors are turned off
		this.robotOutput.pivot(0);
	}

}
