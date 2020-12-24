package Practice;

import java.util.*;

public class Dijkstra {
	
	public static int minV(int dist[],boolean visited[])
	{
		int vertex=-1;
		
		for(int i=0;i<dist.length;i++)
		{
			if(!visited[i] && (vertex==-1 || dist[i]<dist[vertex]))
			{
				vertex=i;
			}
		}
		
		return vertex;
	}

	public static void Dijkstra(int a[][],int n)
	{
		int dist[]=new int[n];
		dist[0]=0;
		for(int i=1;i<n;i++)
		{
			dist[i]=Integer.MAX_VALUE;
		}
		
		boolean visited[]=new boolean[n];
		
		for(int i=0;i<n;i++)
		{
			int minV=minV(dist,visited);
			visited[minV]=true;
			
			for(int j=0;j<n;j++)
			{
				if(a[minV][j]!=0 && !visited[j])
				{
					if(dist[minV]+a[minV][j]<dist[j])
					{
						dist[j]=dist[minV]+a[minV][j];
					}
				}
			}
		}
		
		
		for(int i=0;i<n;i++)
		{
			System.out.println(i+" "+dist[i]);
		}
	}
	
	public static void main(String[] args) {
		Scanner in =new Scanner(System.in);
		
		//No of vertices
		int n=in.nextInt();
		//No of edges
		int e=in.nextInt();
		
		int a[][]=new int[n][n];
		
		for(int i=0;i<e;i++)
		{
			int fv=in.nextInt();
			int sv=in.nextInt();
			int wt=in.nextInt();
			a[fv][sv]=wt;
			a[sv][fv]=wt;
		}
		
		Dijkstra(a,n);

	}

}
