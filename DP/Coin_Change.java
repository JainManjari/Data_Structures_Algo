package DP;

public class Coin_Change {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int C[]= {2,5,3,6};
		int total=10;
		System.out.println(DP(C, total));

	}

	private static int DP(int[] C, int total) {
		
		int n=C.length;
		int m=total;
		
		int a[][]=new int[n+1][m+1];
		
		for(int j=0;j<=m;j++)
		{
			a[0][j]=0;
		}
		
		//Since, there is always the way of not choosing the coin
		for(int i=0;i<=n;i++)
		{
			a[i][0]=1;
		}
		
		for(int i=1;i<=n;i++)
		{
			for(int j=1;j<=m;j++)
			{
				//System.out.println("value "+j+" "+C[i-1]);
				if(j<C[i-1])
				{
					a[i][j]=a[i-1][j];
				}
				else
				{
					a[i][j]=a[i-1][j]+a[i][j-C[i-1]];
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
