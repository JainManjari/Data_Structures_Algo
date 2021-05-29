package Interface;
import java.util.*;

class time2 implements Comparable<time2>
{
	int time;
	
	public int compareTo(time2 t)
	{
		return this.time-t.time;
	}
}
interface time extends Comparable<time>
{
	int t=0;
	
	public default int compareTo(time t1)
	{
		return this.t-t1.t;
	}
}

interface timeNormal extends Comparable<timeNormal>
{
	int t=100;
}

class timeN implements timeNormal
{
	public int compareTo(timeNormal c)
	{
		return this.t-c.t;
	}
}

public class UsingComparable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		
		time2 t1[]=new time2[5];
		
		for(int i=0;i<t1.length;i++)
		{
			System.out.println("input class t1 ");
			t1[i]=new time2();
			t1[i].time=in.nextInt();
		}
		
		Arrays.sort(t1);
		
		System.out.println("print class t1");
		
		for(int i=0;i<t1.length;i++)
		{
			System.out.print(t1[i].time+" ");
		}
		System.out.println();
		
		
		time t2[]=new time[5];
		
		for(int i=0;i<t2.length;i++)
		{
			System.out.println(t2[i].t);
		}
		
		
		timeN t3[]=new timeN[5];
		
		Arrays.sort(t3);
		
		
		for(int i=0;i<t3.length;i++)
		{
			System.out.println(t3[i].t);
		}
		

	}

}
