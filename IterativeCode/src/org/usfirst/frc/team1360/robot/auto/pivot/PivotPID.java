package org.usfirst.frc.team1360.robot.auto.pivot;

import org.usfirst.frc.team1360.robot.IO.RobotOutput;
import org.usfirst.frc.team1360.robot.IO.SensorInput;
import org.usfirst.frc.team1360.robot.auto.AutonCommand;
import org.usfirst.frc.team1360.robot.auto.RobotSubsystems;
import org.usfirst.frc.team1360.robot.util.pid.OrbitPID;

public class PivotPID extends AutonCommand {

	private SensorInput sensroInput;
	private RobotOutput robotOutput;
	
	private double setpoint;
	private OrbitPID pivotController;
	
	public PivotPID(double setpoint) {
		super(RobotSubsystems.ARM);
		
		this.sensroInput = SensorInput.getInstance();
		this.robotOutput = RobotOutput.getInstance();
		this.pivotController = new OrbitPID(0.35, 0.001, 0.01, 0.5);
		
		this.setpoint = setpoint;
	}

	@Override
	public boolean calculate() {
		this.pivotController.SetSetpoint(setpoint);
		this.pivotController.CalculateError();
		this.robotOutput.pivot(this.pivotController.GetOutput());
		return false;
	}

	@Override
	public void override() {
		// TODO Auto-generated method stub
		
	}

}
