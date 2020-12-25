package DP;

import java.util.*;

public class LIS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String x="ABCD";
		String y="BACDBDCD";
		
		System.out.println(LIS(x,y));
		
		
		
	}
	
	public static int LIS(String x,String y)
	{
		int n=x.length();
		int m=y.length();
		
		int a[][]=new int[m+1][n+1];
		
		for(int j=0;j<=n;j++)
		{
			a[0][j]=0;
		}
		
		for(int i=0;i<=m;i++)
		{
			a[i][0]=0;
		}
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				if(x.charAt(j-1)==y.charAt(i-1))
				{
					a[i][j]=1+a[i-1][j-1];
				}
				else
				{
					a[i][j]=a[i][j-1];
				}
			}
		}
		
		int ans=0;
		for(int i=0;i<=m;i++)
		{
			ans=Math.max(ans, a[i][n]);
		}
		
		return ans;
		
	}

}
