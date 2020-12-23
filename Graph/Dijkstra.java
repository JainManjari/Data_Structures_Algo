package Graph;

import java.util.*;

public class Dijkstra {
	
	public static void main(String args[])
	{
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
		dij(a,n);
	}
	
	public static void dij(int a[][],int n)
	{
		boolean visit[]=new boolean[n];
		int dist[]=new int[n];
		dist[0]=0;
		for(int i=1;i<n;i++)
		{
			dist[i]=Integer.MAX_VALUE;
		}
		for(int k=0;k<n-1;k++)
		{
			int vertex=minDist(visit,dist,n);
			visit[vertex]=true;
			for(int i=0;i<n;i++)
			{
				if(!visit[i] && a[vertex][i]!=0)
				{
					int curr=dist[vertex]+a[vertex][i];
					if(dist[i]>curr)
					{
						dist[i]=curr;
					}
				}
			}
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.println(i+" "+dist[i]);
		}
	}
	
	public static int minDist(boolean visit[],int dist[],int n)
	{
		int vertex=-1;
		for(int i=0;i<n;i++)
		{
			if(!visit[i] && (vertex==-1 || dist[i]<dist[vertex]))
			{
				vertex=i;
			}
		}
		return vertex;
	}

}
