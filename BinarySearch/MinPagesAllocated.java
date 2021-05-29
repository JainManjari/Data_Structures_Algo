package BinarySearch;
import java.util.*;

public class MinPagesAllocated {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[]= {10,20,30,40};
		
		System.out.println(minPages(a, 2));

	}
	
	public static int minPages(int a[],int k)
	{
		int n=a.length;
		
		int low=Integer.MIN_VALUE;
		int high=0;
		
		for(int i=0;i<n;i++)
		{
			high+=a[i];
			low=Math.max(low, a[i]);
		}
		
		int res=0;
		
		while(low<=high)
		{
			int mid=(low+high)/2;
			
			if(isFeasible(a, n, k, mid))
			{
				res=mid;
				high=mid-1;
			}
			else
			{
				low=mid+1;
			}
			
		}
		
		return res;
	}
	
	public static boolean isFeasible(int a[],int n,int k,int ans)
	{
		int sum=0;
		int req=1;
		
		for(int i=0;i<n;i++)
		{
			if(sum+a[i]>ans)
			{
				req++;
				sum=a[i];
			}
			else
			{
				sum+=a[i];
			}
		}
		
		return (req<=k);
	}

}
