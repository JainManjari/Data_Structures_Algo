package Vehicle;

public abstract class Car extends Vehicle {
	
	int numGears;
	boolean isConvertible;
	
	public Car()
	{
		super(10);
	}
	
	public Car(int numGears,int maxSpeed)
	{
		super(maxSpeed);
		this.numGears=numGears;
		System.out.println("Car Constructor");
	}
	
	public boolean isConvertible()
	{
		return isConvertible;
	}

	@Override
	public boolean isMotorised() {
		// TODO Auto-generated method stub
		return false;
	}

	

//	public void print() // to rectify it rename it to printCar() or remove final from Vehicle print
//	{
//		super.print();
//		System.out.println("Car Description:"+" "+this.numGears+" "+this.isConvertible);
//	}

}
