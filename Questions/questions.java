package Questions;

import java.util.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;





public class questions {
	
	
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		
		
		int a[]= {-10,-20,-30,-40,0,0,0};
		System.out.println(secondLargest(a));
		
		
		//         0,1,2,3,4,5,6,7,8,9
		int a2[]= {4,5,6,7,8,9,10,1,2,3};
		int K=1;
		System.out.println(find(a2,0,a2.length-1,K));
		
		

		
		
	
		
				
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
