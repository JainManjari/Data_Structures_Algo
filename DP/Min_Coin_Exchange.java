package DP;

public class Min_Coin_Exchange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int C[]= {1,5,6,9};
		int total=10;
		System.out.println(DP(C,total));
	}

	private static int DP(int[] C, int total) {
		int n=C.length;
		int m=total;
		
		int a[][]=new int[n+1][m+1];
		
		for(int j=0;j<=m;j++)
		{
			a[0][j]=0;
		}
		
		for(int i=0;i<=n;i++)
		{
			a[i][0]=0;
		}
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				if(j<C[i-1])
				{
					a[i][j]=a[i-1][j];
				}
				else
				{
					if(i==1)
					{
						a[i][j]=Math.max(a[i-1][j], 1+a[i][j-C[i-1]]);
					}
					else
					{
						a[i][j]=Math.min(a[i-1][j], 1+a[i][j-C[i-1]]);
					}
					
				}
			}
		}
		
		for(int i=0;i<=n;i++)
		{
			for(int j=0;j<=m;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
		
		return a[n][m];
		
	}

}
