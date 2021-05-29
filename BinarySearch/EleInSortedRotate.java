package BinarySearch;
import java.util.*;

public class EleInSortedRotate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[]= {20,22,25,1,7,7,9,10};
		
		//System.out.println(foundIndex(a,2000));
		
		System.out.println(pivot(a));

	}
	
	public static int foundIndex(int a[],int ele)
	{
		int index=-1;
		
		int start=0;
		int last=a.length-1;
		
		
		while(start<=last)
		{
			int mid=(start+last)/2;
			
			System.out.println("func "+start+" "+mid+" "+last);
			
			if(a[mid]==ele)
			{
				return mid;
			}
			if(a[start]<=a[mid])
			{
				if(a[start]<=ele && ele<a[mid])
				{
					last=mid-1;
				}
				else
				{
					start=mid+1;
				}
			}
			else
			{
				if(a[mid]<ele && ele<=a[last])
				{
					start=mid+1;
				}
				else
				{
					last=mid-1;
				}
			}
		}
		
		
		return index;
	}
	
	
	public static int pivot(int a[])
	{
		
		int start=0;
		int last=a.length-1;
		
		while(start<last)
		{
			int mid=(start+last)/2;
			System.out.println("func "+start+" "+mid+" "+last);
			
			if(a[mid]==a[last])
			{
				last--;
			}
			else if(a[mid]>a[last])
			{
				start=mid+1;
			}
			else
			{
				last=mid;
			}
		}
		
		return a[last];
	}
	
	
	public static int peakEle(int a[])
	{
		int start=0;
		int last=a.length-1;
		int n=a.length;
		
		while(start<=last)
		{
			int mid=(last+start)/2;
			
			if((mid==0 || a[mid-1]<a[mid]) && (mid==n-1 || a[mid]>a[mid+1]))
			{
				return mid;
			}
			else if(mid>0 && a[mid-1]>a[mid])
			{
				last=mid-1;
			}
			else
			{
				start=mid+1;
			}
		}
		return -1;
	}

}
