package org.usfirst.frc.team1360.robot.IO;

import org.usfirst.frc.team1360.robot.teleop.TeleopControl;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class SensorInput {
	private static SensorInput instance;
	private RobotOutput robotOutput;
	private TeleopControl teleopControl;
	
	private Encoder pivotEncoder;
	private Encoder leftSide;
	private Encoder rightSide;
	
	private final int HALL_EFFECT_SENSOR_MAX_RATE = 136;
	
	// TODO: Change back to private.
	private SensorInput()
	{
		this.robotOutput = RobotOutput.getInstance();
		this.pivotEncoder = new Encoder(4, 5);
		this.leftSide = new Encoder(0, 1, false, EncodingType.k1X);
		
		this.leftSide.setDistancePerPulse(1);
		this.leftSide.setMaxPeriod(1.0);
		this.leftSide.setMinRate(1.0);
		this.leftSide.setPIDSourceType(PIDSourceType.kRate);
		this.leftSide.setSamplesToAverage(10);
		
		this.rightSide = new Encoder(2, 3, false, EncodingType.k1X);
		this.rightSide.setDistancePerPulse(1);
		this.rightSide.setMaxPeriod(1.0);
		this.rightSide.setMinRate(1.0);
		this.rightSide.setPIDSourceType(PIDSourceType.kRate);
		this.rightSide.setSamplesToAverage(10);
		
	}
	
	public static SensorInput getInstance()
	{
		if(instance == null)
		{
			SensorInput.instance = new SensorInput();
		}
		
		return instance;
	}
	
	public void calculate()
	{
		SmartDashboard.putNumber("Pivot Encoder: ", this.getPivotEncoder());
		SmartDashboard.putNumber("Left Speed: ", this.getLeftSpeed());
		SmartDashboard.putNumber("Right Speed: ", this.getRightSpeed());
		SmartDashboard.putNumber("Pivot Degrees: ", this.getPivotEncoderDegrees());
	}
	
	public double getPivotEncoder()
	{
		return pivotEncoder.get();
	}
	
	public double getPivotEncoderDegrees()
	{
		return 145 + (pivotEncoder.get() / 716.8);
	}
	
	public double getLeftSpeed()
	{
		return leftSide.getRate() / HALL_EFFECT_SENSOR_MAX_RATE;
		//return leftSide.getRate();
	}
	
	public double getRightSpeed()
	{
		return rightSide.getRate() / HALL_EFFECT_SENSOR_MAX_RATE;
	}
	
	public void reset()
	{
		pivotEncoder.reset();
	}
	
}
