package org.usfirst.frc.team1360.robot.teleop;

import org.usfirst.frc.team1360.robot.IO.HumanInput;
import org.usfirst.frc.team1360.robot.IO.RobotOutput;
import org.usfirst.frc.team1360.robot.IO.SensorInput;
import org.usfirst.frc.team1360.robot.util.pid.OrbitPID;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TeleopPivot implements TeleopComponent {

	private static TeleopPivot instance;
	private RobotOutput robotOutput;
	private HumanInput humanInput;
	private SensorInput sensorInput;
	
	private OrbitPID pivotController;
	
	private TeleopPivot()
	{
		this.robotOutput = RobotOutput.getInstance();
		this.humanInput = HumanInput.getInstance();
		this.sensorInput = SensorInput.getInstance();
		this.pivotController =  new OrbitPID(0.001, 0.1, 0.1, 20);
	}
	
	public static TeleopPivot getInstance()
	{
		if(instance == null)
		{
			instance = new TeleopPivot();
		}
		
		return instance;
	}
	
	@Override
	public void calculate() {
		// TODO Auto-generated method stub
		
		double speed = -this.humanInput.getOperatorPivot();
		this.pivotController.SetInput(this.sensorInput.getPivotEnvoder());
		
		if(Math.abs(speed) > 0.2)
		{
			robotOutput.pivot(speed * 0.45);
		}
		else if (humanInput.getOperatorIntakeHeight())
		{
			this.pivotController.SetSetpoint(0);
			this.pivotController.CalculateError();
			this.robotOutput.pivot(this.pivotController.GetOutput());
		} 
		else if (humanInput.getOperatorBatterShot())
		{
			this.pivotController.SetSetpoint(500);
			this.pivotController.CalculateError();
			this.robotOutput.pivot(this.pivotController.GetOutput());

		}
		else if (humanInput.getOperatorOuterworksShot())
		{
			this.pivotController.SetSetpoint(250);
			this.pivotController.CalculateError();
			this.robotOutput.pivot(this.pivotController.GetOutput());

		} 
		else
		{
			robotOutput.pivot(0);
		}
		
		SmartDashboard.putNumber("P = ", this.pivotController.GetP());
		SmartDashboard.putNumber("I = ", this.pivotController.GetI());
		SmartDashboard.putNumber("D = ", this.pivotController.GetD());
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		this.robotOutput.pivot(0);
	}

}
