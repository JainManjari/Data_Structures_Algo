package VehicleTemp;

import Vehicle.*;

public class Truck extends Vehicle {
	
	int maxCapacity;
	
	public Truck()
	{
		super(100);
	}
	
	public void print()
	{
		System.out.println("Truck Des: "+this.maxCapacity+" "+this.getMaxSpeed()+" "+this.color);
	}

	@Override
	public boolean isMotorised() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String companyName() {
		// TODO Auto-generated method stub
		return null;
	}

}
