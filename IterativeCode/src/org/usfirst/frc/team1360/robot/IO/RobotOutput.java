package org.usfirst.frc.team1360.robot.IO;

import org.usfirst.frc.team1360.robot.Robot;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Victor;

public class RobotOutput {
	
	private static RobotOutput instance;
	
	//Drive Motors
	private Victor driveLeftFront;
	private Victor driveLeftBack;
	private Victor driveRightFront;
	private Victor driveRightBack;
	private Victor intakeMotor;
	private Victor shootMotorL;
	private Victor shootMotorR;
	private Victor pivotMotor;
	private Solenoid driveSolenoid;
	
	//Initialize the motors and stuff
	private RobotOutput()
	{
		driveLeftFront = new Victor(0);
		driveLeftBack = new Victor(1);
		driveRightFront = new Victor(2);
		driveRightBack = new Victor(3);
		shootMotorL = new Victor(7);
		shootMotorR = new Victor(6);
		pivotMotor = new Victor(5);
		intakeMotor = new Victor(4);
		
		driveSolenoid = new Solenoid(0);
		
	}
	
	//Still dont know what this is used for
	public static RobotOutput getInstance()
	{
		if(instance == null)
		{
			RobotOutput.instance = new RobotOutput();
		}
		
		return instance;
	}
	
	/*
	 * TankDrive is one method of drive code
	 * left: the left side speed.  0 to 1
	 * right: the right side speed.  0 to 1
	 */
	public void tankDrive(double left, double right)
	{
		driveLeftFront.set(-left);
		driveLeftBack.set(-left);
		driveRightFront.set(right);
		driveRightBack.set(right);
	}
	
	/*
	 * The second was to do drive code
	 * speed: How fast the robot is going. 0 to 1
	 * turn: How fast the robot is turning. 0 to 1
	 */
	public void arcadeDrive(double speed, double turn)
	{
		double left = (-turn) - speed;
		double right = (-turn) + speed;
		
		tankDrive(left, right);
	}
	
	public void actuateDriveTrain(boolean input)
	{
		driveSolenoid.set(input);
	}
	
	public void intake(double speed)
	{
		intakeMotor.set(speed);
	}
	
	public void setShooter(double lSpeed, double rSpeed)
	{
		shootMotorL.set(-lSpeed);
		shootMotorR.set(rSpeed);
	}
	
	public void pivot(double speed)
	{
		pivotMotor.set(speed);
	}
	
	public void stopAll()
	{
		driveLeftFront.set(0);
		driveLeftBack.set(0);
		driveRightFront.set(0);
		driveRightBack.set(0);
		shootMotorL.set(0);
		shootMotorR.set(0);
		pivotMotor.set(0);
		intakeMotor.set(0);
	}
}
