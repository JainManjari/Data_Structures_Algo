package DP;

public class KnapStack {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int P[]= {1,2,5,6};
		int Wt[]= {2,3,4,5};
		int Wmax=8;
		System.out.println(DP(P, Wt, Wmax));

	}
	public static int DP(int P[],int Wt[],int Wmax)
	{
		int n=Wmax;
		int m=P.length;
		int a[][]=new int[m+1][n+1];
		
		for(int j=0;j<=n;j++)
		{
			a[0][j]=0;
		}
		
		for(int i=0;i<=m;i++)
		{
			a[i][0]=0;
		}
		
		// A[i,w] = max(A[i-1,w], A[i-1,w-wt[i]+P[i])
		
		for(int i=1;i<=m;i++)
		{
			for(int j=1;j<=n;j++)
			{
				//System.out.println("Val "+j+" "+Wt[i-1]);
				if(j<Wt[i-1])
				{
					a[i][j]=a[i-1][j];
				}
				else
				{
					a[i][j]=Math.max(a[i-1][j], a[i-1][j-Wt[i-1]]+P[i-1]);
				}
			}
		}
		
//		for(int i=0;i<=m;i++)
//		{
//			for(int j=0;j<=n;j++)
//			{
//				System.out.print(a[i][j]+" ");
//			}
//			System.out.println();
//		}
		
		return a[m][n];
	}
}
