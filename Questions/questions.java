package Questions;

import java.util.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;





public class questions {
	
	
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		
		
		int a[]= {-10,-20,-30,-40,0,0,0};
		//System.out.println(secondLargest(a));
		
		
		//         0,1,2,3,4,5, 6, 7,8,9
		int a2[]= {26,23,22,14,5,6,4}; //{30, 40, 50, 10, 20};
		int K=30;
		System.out.println(find(a2,0,a2.length-1,K));
		System.out.println(findPivot(a2, 0, a2.length-1));
		System.out.println(findMax(a2,0,a2.length-1));
		
		
		int one='8'-'0';

		System.out.println((char)(one+97));
				
	}
	
	
	public static int findMax(int a[],int s,int e)
	{
		if(s>e)
		{
			return -1;
		}
		if(s==e)
		{
			return s;
		}
		int mid=(s+e)/2;
		if(a[mid-1]<a[mid] && a[mid]>a[mid+1])
		{
			return mid;
		}
		if(a[s]<=a[mid])
		{
			return findMax(a, mid+1, e);
		}
		return findMax(a, s, mid-1);
	}
	
	public static int findPivot(int a[],int s,int e)
	{
		if(s>=e)
		{
			return -1;
		}
		int mid=(s+e)/2;
		if(a[mid]>a[mid+1])
		{
			return mid+1;
		}
		if(a[s]<=a[mid])
		{
			return findPivot(a,mid+1,e);
		}
		return findPivot(a,s,mid-1);	
	}
	
	public static int find(int a[],int s,int e,int ele)
	{
		if(s>e)
		{
			return -1;
		}
		
		
		int mid=(s+e)/2;
		
		//System.out.println("index "+s+" "+e+" "+mid);
		
		if(a[mid]==ele)
		{
			return mid;
		}
		
		if(a[s]<=a[mid])
		{
			if(a[s]<= ele && ele<=a[mid])
			{
				return find(a,s,mid-1,ele);
			}
			return find(a,mid+1,e,ele);
		}
		
		if(ele>=a[mid] && ele<=a[e])
		{
			return find(a,mid+1,e,ele);
		}
		return find(a,s,mid-1,ele);
		
	}
	
	
	
	
	public static int secondLargest(int a[])
	{
		int sec=Integer.MIN_VALUE;
		int larg=Integer.MIN_VALUE;
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>larg)
			{
				sec=larg;
				larg=a[i];
			}
			else if(sec<a[i] && a[i]<larg)
			{
				sec=a[i];
			}
		}
		
		return sec;
	}
	
	
	
	
	
	
	
	
	
	        
}
