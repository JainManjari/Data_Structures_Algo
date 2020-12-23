package Recursion;
import java.util.*;

public class array_seq {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[]= {3,10,24};
//		String ans[]=ret_sub(a,0);
//		for(int i=0;i<ans.length;i++)
//		{
//			System.out.println(ans[i]);
//		}
//		int ans1[][]=ret_sub2(a,0);
//		for(int i=0;i<ans1.length;i++)
//		{
//			for(int j=0;j<ans1[i].length;j++)
//			{
//				System.out.print(ans1[i][j]+" ");
//			}
//			System.out.println();
//		}
		int out[]= {};
		print_sub(a,0,out);
	}
	
	public static String[] ret_sub(int a[],int start)
	{
		if(a.length==start)
		{
			String a1[]= {""};
			return a1;
		}
		String small_ans[]=ret_sub(a,start+1);
		String ans[]=new String[small_ans.length*2];
		int k=0;
		for(int i=0;i<small_ans.length;i++)
		{
			ans[k++]=small_ans[i];
		}
		for(int i=0;i<small_ans.length;i++)
		{
			String out=String.valueOf(a[start])+" "+small_ans[i];
			ans[k++]=out;
		}
		return ans;
	}
	public static int[][] ret_sub2(int a[],int start)
	{
		if(a.length==start)
		{
			int a1[][]= new int[1][0];
			return a1;
		}
		int small_ans[][]=ret_sub2(a,start+1);
		int ans[][]=new int[small_ans.length*2][];
		int k=0;
		for(int i=0;i<small_ans.length;i++)
		{
			ans[k]=new int[small_ans[i].length];
			for(int j=0;j<small_ans[i].length;j++)
			{
				ans[k][j]=small_ans[i][j];
			}
			k++;

		}
		for(int i=0;i<small_ans.length;i++)
		{
			ans[k]=new int[small_ans[i].length+1];
			ans[k][0]=a[start];
			for(int j=0;j<small_ans[i].length;j++)
			{
				ans[k][j+1]=small_ans[i][j];
			}
			k++;
		}

		
		return ans;
	}
	
	public static void print_sub(int a[],int start,int out[])
	{
		if(a.length==start)
		{
			for(int i=0;i<out.length;i++)
			{
				System.out.print(out[i]+" ");
			}
			System.out.println();
			return;
		}
		
		print_sub(a,start+1,out);
		int out1[]=new int[out.length+1];
		int k=0;
		for(int i=0;i<out.length;i++)
		{
			out1[k++]=out[i];
		}
		out1[k]=a[start];
		print_sub(a,start+1,out1);
	}

}
