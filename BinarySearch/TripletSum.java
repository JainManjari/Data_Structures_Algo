package BinarySearch;
import java.util.*;

public class TripletSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[]= {2,3,4,8,9,20,40};
		
		System.out.println(tripletSum(a, 32));

	}
	
	
	public static boolean tripletSum(int a[],int tri)
	{
		int n=a.length;
		
		for(int i=0;i<n;i++)
		{
			int sum=a[i];
			int low=i+1;
			int high=n-1;
			
			//System.out.println("first loop i "+i+" "+low+" "+high+" "+sum+" "+tri);
			
			while(low<high)
			{
				sum=a[i];
				sum+=a[low]+a[high];
				//System.out.println("second loop ii "+" "+low+" "+high+" "+sum);
				if(sum==tri)
				{
					return true;
				}
				else if(sum>tri)
				{
					high--;
				}
				else
				{
					low++;
				}
			}
		}
		
		
		return false;
	}

}
