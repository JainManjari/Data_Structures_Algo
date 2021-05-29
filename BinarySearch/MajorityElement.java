package BinarySearch;
import java.util.*;

public class MajorityElement {
	
	public static void main(String args[])
	{
		
		int a[]= {8,6,6,4};
		
		System.out.println(count(a));
		
	}
	
	
	public static boolean count(int a[])
	{
		int count=1;
		int res=0;
		
		
		//checking for a candidate element
		for(int i=1;i<a.length;i++)
		{
			if(a[res]==a[i])
			{
				count++;
			}
			else
			{
				count--;
			}
			if(count==0)
			{
				count=1;
				res=i;
			}
		}
		
		count=0;
		
		//checking whether the candidate element is actually a majority element
		for(int i=0;i<a.length;i++)
		{
			if(a[i]==a[res])
			{
				count++;
			}
		}
		
		if(count>(a.length/2))
		{
			return true;
		}
		
		return false;
	}

}
