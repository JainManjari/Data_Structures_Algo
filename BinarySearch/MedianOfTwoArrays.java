package BinarySearch;
import java.util.*;

public class MedianOfTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a1[]= {10,20,30,40,50};
		
		int a2[]= {5,15,25,27,28,55,65,75,85};
		
		System.out.println(median(a1, a2));

	}
	
	public static double median(int a1[],int a2[])
	{
		//a1 is smaller than a2
		int begin1=0;
		int end1=a1.length;
		
		int n1=a1.length;
		int n2=a2.length;
		
		while(begin1<=end1)
		{
			int i1=(begin1+end1)/2;
			int i2=((n1+n2+1)/2)-i1;
			
			int min1= (i1==n1) ? Integer.MAX_VALUE : a1[i1];
			int max1= (i1==0) ? Integer.MIN_VALUE : a1[i1-1];
			
			int min2= (i2==n2) ? Integer.MAX_VALUE : a2[i2];
			int max2= (i2==0) ? Integer.MIN_VALUE : a2[i2-1];
			
			
			if(max1<=min2 && max2<=min1)
			{
				if((n1+n2)%2==0)
				{
					return ((double)Math.max(max1, max2)+(double)Math.min(min1, min2))/2;
				}
				return (double)(Math.max(max1, max2));
			}
			
			if(max1>min2)
			{
				end1=i1-1;
			}
			else
			{
				begin1=i1+1;
			}
					
		}
		
		return (double)0;
	}

}
