package org.usfirst.frc.team1360.robot.util.pid;

public class PIDSpeedController {
	
	private double p;
	private double i;
	private double d;
	private double error;
	private double input;
	private double output;
	private double setpoint;
	
	private double dP;
	private double dI;
	private double dD;

	private double dError;
	
	private double dInput;
	private double dOutput;
	private double dSetpoint;

	public PIDSpeedController(double constantP, double constantI, double constantD)
	{
		this.dP = constantP;
		this.dI = constantI;
		this.dD = constantD;
	}

	public void SetConstants(double constantP, double constantI, double constantD)
	{
		this.dP = constantP;
		this.dI = constantI;
		this.dD = constantD;
	}

	public void SetP(double constantP) { this.dP = constantP; }
	public double GetP() { return dP; }

	public void SetI(double constantI) { this.dI = constantI; }
	public double GetI() { return dI; }

	public void SetD(double constantD) { this.dD = constantD; }
	public double GetD() { return dD; }

	public double GetError() { return dError; }
	
}
 