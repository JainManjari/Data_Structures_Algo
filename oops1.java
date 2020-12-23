import java.util.*;

class Student
{
	String name;
	private final int rollNo;
	static private int numStd;
	
	public Student(String name,int rollNo)
	{
		System.out.println(this);
		this.name=name;
		this.rollNo=rollNo;
		numStd++;
	}
//	
	public static int getNumStd()
	{
		return numStd;
	}
//	public Student(String n2)
//	{
//		name=n2;
//	}
//	
	public int getRoll()
	{
		return rollNo;
	}
	
//	public void setRoll(int n)
//	{
//		if(n<=0)
//		{
//			return;
//		}
//		rollNo=n;
//	}
//	
	public void print()
	{
		System.out.println(this.name+" "+this.rollNo);
	}
}
public class oops1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Scanner in=new Scanner(System.in);
     // Student s1=new Student("Mj");
      
      Student s1=new Student("BV",22);
      s1.print();
      System.out.println(s1);
      
      Student s2=new Student("Mj",121);
      s2.print();
      System.out.println(s2);
     // System.out.println(s2.numStd);
      System.out.println(Student.getNumStd());
//      s1.name="Mj1";
//      s1.setRoll(10);
//      System.out.println(s1.getRoll()+" "+s1.name);
      //s1.setRoll(4);
      //System.out.println(s1.getRoll());
     // s1.rollNo=16;
      
   //   Student s2=new Student();
   //   s2.name="Bv";
      //s2.rollNo=22;
   //   System.out.println(s1+" "+s2);
	}

}
