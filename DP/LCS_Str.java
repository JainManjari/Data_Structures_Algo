package DP;

public class LCS_Str {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String x="stone";
		String y="longest";
		
		//time o(m*n)
		
		System.out.println(LIS_Rec(x,y));
		
		System.out.println(DP(x, y));
		
		
	}

	private static int LIS_Rec(String x, String y) {
		
		if(x.length()==0 ||y.length()==0)
		{
			return 0;
		}
		if(x.charAt(0)==y.charAt(0))
		{
			return 1+LIS_Rec(x.substring(1), y.substring(1));
		}
		return Math.max(LIS_Rec(x.substring(1), y),LIS_Rec(x, y.substring(1)));
		
	}
	
	public static int DP(String x,String y)
	{
		int n=x.length();
		int m=y.length();
		
		int a[][]=new int[n+1][m+1];
		
		for(int i=0;i<=n;i++)
		{
			a[i][0]=0;
		}
		
		for(int j=0;j<=m;j++)
		{
			a[0][j]=0;
		}
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				if(x.charAt(i-1)==y.charAt(j-1))
				{
					a[i][j]=1+a[i-1][j-1];
				}
				else
				{
					a[i][j]=Math.max(a[i-1][j], a[i][j-1]);
				}
			}
		}
		
		return a[n][m];
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	private static int LIS_Memo(String x,String y)
//	{
//		int m=x.length();
//		int n=y.length();
//		
//		int a[][]=new int[m+1][n+1];
//		
//		for(int i=0;i<=m;i++)
//		{
//			for(int j=0;j<=n;j++)
//			{
//				a[i][j]=-1;
//			}
//		}
//		
//		return LIS_Memo_H(x,y,a,m,n);
//		
//	}

//	private static int LIS_Memo_H(String x, String y, int[][] a,int m,int n) {
//	      if(x.length()==0 || y.length()==0)
//	      {
//	    	  a[m][n]=0;
//	    	  return a[m][n];
//	      }
//	      
//	      if(a[m][n]>0)
//	      {
//	    	  return a[m][n];
//	      }
//	      
//	      if(x.charAt(0)==y.charAt(0))
//	      {
//	    	  a[m][n]=1+LIS_Memo_H(x.substring(1), y.substring(1), a, m, n);
//	      }
//	      else
//	      {
//	    	  a[m][n]=Math.max(LIS_Memo_H(x.substring(1), y, a, m, n), LIS_Memo_H(x, y.substring(1), a, m, n));
//	      }
//	      return a[m][n];
//	}
	
	

}
