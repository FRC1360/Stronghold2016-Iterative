package org.usfirst.frc.team1360.robot.IO;

import org.usfirst.frc.team1360.robot.util.XboxRemote;

public class HumanInput {
	//Dont know what this is for
	private static HumanInput instance;
	
	//These two are the Driver and Operator remotes
	private XboxRemote driver;
	private XboxRemote operator;

	private boolean autonIncreaseStepWasPressed = false;
	private boolean autonDecreaseStepWasPressed = false;
	
	
	//Initialize the driver and operator remotes
	private HumanInput()
	{
		this.driver = new XboxRemote(0);
		this.operator = new XboxRemote(1);
	}
	
	public static HumanInput getInstance()
	{
		if(instance == null)
		{
			HumanInput.instance = new HumanInput();
		}
		
		return instance;
	}
	
	//Driver
	public double getDriverBackward()
	{
		return this.driver.getLeftTrigger();
	}
	
	public double getDriverForward()
	{
		return this.driver.getRightTrigger();
	}
	
	public boolean getDriverActuate()
	{
		return this.driver.getButtonA();
	}
	
	public double getDriverTurn()
	{
		return this.driver.getLeftXAxis();
	}
	
	public double getDriverLeftY()
	{
		return this.driver.getLeftYAxis();
	}
	
	//Operator
	public double getOperatorInatke()
	{
		return this.operator.getRightTrigger();
	}
	
	public double getOperatorOutake()
	{
		return this.operator.getLeftTrigger();
	}
	
	public double getOperatorPivot()
	{
		return -this.operator.getLeftYAxis();
	}
	
	
	//Operator Buttons for Shooting
	public boolean getOperatorIntakeHeight()
	{
		return this.operator.getButtonA();
	}
	
	public boolean getOperatorShoot()
	{
		return this.operator.getButtonY();
	}
	
	public boolean getOperatorUpPosition()
	{
		return this.operator.getButtonX();
	}
	
	public boolean getOperatorLowgoal()
	{
		return this.operator.getButtonB();
	}
	
	public boolean getOperatorRevUntilShoot()
	{
		return this.operator.getButtonRB();
	}
	
	public boolean getOperatorShootPosition()
	{
		return this.operator.getButtonLB();
	}
	
	//Auto
    public boolean getAutonSetModeButton() {
        return this.driver.getButtonA();
    }
    
    public boolean getAutonSetDelayButton() {
        return this.driver.getButtonB();
    }
    
    public double getAutonSelectStick() {
        return this.driver.getLeftYAxis();
    }

    public boolean getAutonStepIncrease() {
    	// only returns true on rising edge
    	boolean result = this.driver.getButtonRB() && !this.autonIncreaseStepWasPressed;
    	this.autonIncreaseStepWasPressed = this.driver.getButtonRB();
    	return result;
    	
    }
    
    public boolean getAutonStepDecrease() {
    	// only returns true on rising edge
    	boolean result = this.driver.getButtonLB() && !this.autonDecreaseStepWasPressed;
    	this.autonDecreaseStepWasPressed = this.driver.getButtonLB();
    	return result;
    
    }
	
}
