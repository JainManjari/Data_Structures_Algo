package Graph;

import java.util.*;

public class Prim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int e=in.nextInt();
		int a[][]=new int[n][n];
		for(int i=0;i<e;i++)
		{
			int fv=in.nextInt();
			int sv=in.nextInt();
			int weight=in.nextInt();
			a[fv][sv]=weight;
			a[sv][fv]=weight;
		}
		
		prim(a,n);

	}

	private static void prim(int[][] a, int n) {
		int parent[]=new int[n];
		parent[0]=-1;
		int wt[]=new int[n];
		wt[0]=0;
		for(int i=1;i<n;i++)
		{
			wt[i]=Integer.MAX_VALUE;
		}
		boolean visit[]=new boolean[n];
		for(int j=0;j<n;j++)
		{
			int vertex=minVertex(visit,n,wt);
			visit[vertex]=true;
			for(int i=0;i<n;i++)
			{
				if(!visit[i] && a[vertex][i]!=0)
				{
					if(wt[i]>a[vertex][i])
					{
						wt[i]=a[vertex][i];
						parent[i]=vertex;
					}
				}
			}
		}
		for(int i=0;i<n;i++)
		{
			System.out.println(i+" "+parent[i]+" "+wt[i]);
		}
	}
	
	private static int minVertex(boolean visit[],int n,int wt[])
	{
		int vertex=-1;
		for(int i=0;i<n;i++)
		{
			if(!visit[i] && (vertex==-1 || wt[i]<wt[vertex]))
			{
				vertex=i;
			}
		}
		return vertex;
	}

}