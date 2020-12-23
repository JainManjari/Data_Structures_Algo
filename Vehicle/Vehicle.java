package Vehicle;

public  class Vehicle {

	protected String color;
	private int maxSpeed;
	
//	public Vehicle()
//	{
//		System.out.println("Vehicle Const");
//	}
//	
//	public abstract boolean isMotorised();
//	public abstract String companyName();
	
	public Vehicle(int maxSpeed)
	{
		this.maxSpeed=maxSpeed;
		System.out.println("Vehicle Constructor");
	}
	
	public void setMaxSpeed(int maxSpeed)
	{
		this.maxSpeed=maxSpeed;
	}
	
	public int getMaxSpeed()
	{
		return this.maxSpeed;
	}
	
	public  void print()
	{
		System.out.println("Vehicle Description:"+" "+this.color+" "+this.maxSpeed);
	}
}
