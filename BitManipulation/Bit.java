package BitManipulation;
import java.util.*;

public class Bit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=234647;
		
		System.out.println(countSetBits(n));
		System.out.println(countSetBitsBrian(n));
		System.out.println(power(11, 4));
		
		printSubset("abcd");

	}
	
	
	public static int countSetBits(int n)
	{
		int count=0;
		while(n>0)
		{
			if((n&1)==1)
			{
				count++;
			}
			n=n>>>1;
		}
		return count;
	}
	
	public static int countSetBitsBrian(int n)
	{
		int count=0;
		
		while(n>0)
		{
			n=(n&(n-1));
			count++;
		}
		
		return count;
	}
	
	public static void printSubset(String s)
	{
		int n=s.length();
		int powerSize=power(2,n);
		
		for(int i=0;i<powerSize;i++)
		{
			for(int j=0;j<n;j++)
			{
			    if((i & (1<<j))!=0)
			    {
			    	System.out.print(s.charAt(j));
			    }
			}
			System.out.println();
		}
	}
	
	public static int power(int x,int n)
	{
		int res=1;
		
		while(n>0)
		{
			if(n%2!=0)
			{
				res*=x;
			}
			x=x*x;
			n=n/2;
		}
		return res;
	}

}
