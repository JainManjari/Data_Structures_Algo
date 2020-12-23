package Recursion;
import java.util.*;


public class sumsubsetK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {5,12,3,17,1,18,15,3,17};
		int k=6;
		int out[]= {};
		int a1[][]=ret_sum(a,k,0);
		for(int i=0;i<a1.length;i++)
		{
			for(int j=0;j<a1[i].length;j++)
			{
				System.out.print(a1[i][j]+" ");
			}
			System.out.println();
		}

	}
	
	public static int[][] ret_sum(int a[],int k,int s)
	{
		if(a.length==s)
		{
			if(k==0)
			{
				return new int[1][0];
			}
			else
			{
				return new int[0][0];
			}
		}
		int small_ans1[][]=ret_sum(a,k,s+1);
		int small_ans2[][]=ret_sum(a,k-a[s],s+1);
		
		int ans[][]=new int[small_ans1.length+small_ans2.length][];
		int k1=0;
		for(int i=0;i<small_ans1.length;i++)
		{
			ans[k1]=new int[small_ans1[i].length];
			for(int j=0;j<small_ans1[i].length;j++)
			{
				ans[k1][j]=small_ans1[i][j];
			}
			k1++;
		}
		for(int i=0;i<small_ans2.length;i++)
		{
			ans[k1]=new int[small_ans2[i].length+1];
			ans[k1][0]=a[s];
			for(int j=0;j<small_ans2[i].length;j++)
			{
				ans[k1][j+1]=small_ans2[i][j];
			}
			k1++;
		}
		
		
		
		return ans;
	}
	
	public static void print_sum(int a[],int k,int s,int out[])
	{
		if(a.length==s)
		{
			if(k==0)
			{
				for(int i=0;i<out.length;i++)
				{
					System.out.print(out[i]+" ");
				}
				System.out.println();
			}
			return;
		}
		print_sum(a,k,s+1,out);
		int out1[]=new int[out.length+1];
		int k1=0;
		for(int i=0;i<out.length;i++)
		{
			out1[k1++]=out[i];
		}
		out1[k1++]=a[s];
		print_sum(a,k-a[s],s+1,out1);
		
	
	}

}
