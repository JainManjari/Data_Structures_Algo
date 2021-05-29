package Sorting;
import java.util.*;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=10;
		int k=15;
		int a[]= {0,2,3,2,1,1,11,10,9,4};
		
		countSort(a, n, k);
		
		for(int i=0;i<n;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	public static void countSort(int a[],int n,int k)
	{
		int count[]=new int[k];
		Arrays.fill(count, 0);
		
		for(int i=0;i<n;i++)
		{
			count[a[i]]++;
		}
		
		for(int i=1;i<k;i++)
		{
			count[i]+=count[i-1];
		}
		
		int output[]=new int[n];
		
		for(int i=n-1;i>=0;i--)
		{
			output[count[a[i]]-1]=a[i];
			count[a[i]]--;
		}
		
		for(int i=0;i<n;i++)
		{
			a[i]=output[i];
		}
	}

}
