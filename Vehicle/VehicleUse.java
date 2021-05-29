package Vehicle;
import Vehicle.*;

public class VehicleUse {
	
	public static void main(String args[])
	{
		Vehicle v1=new Vehicle(10);
		v1.color="red";
		v1.setMaxSpeed(100);
		v1.print();
		
		Vehicle v=new Car(10,20);
		//v.isMotorised();
		v.print();
		
		//v.setMaxSpeed(4);
		
		//Car c1=new Car(4,10);
//		c1.numGears=4;
		//c1.color="black";
		//c1.setMaxSpeed(200);
		//c1.print();
		
	//	c1.printCar();
	}

}
