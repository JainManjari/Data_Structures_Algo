package Practice;
import java.util.*;

/*
 * 4 4
	0 1 3
	0 3 5
	1 2 1
	2 3 8
 */

public class Prim {
	
	public static void printPrim(int a[][],int n)
	{
		
		int parent[]=new int[n];
		parent[0]=-1;
		
		boolean visited[]=new boolean[n];
		
		int wt[]=new int[n];
		wt[0]=0;
		for(int i=1;i<n;i++)
		{
			wt[i]=Integer.MAX_VALUE;
		}
		
		for(int i=0;i<n;i++)
		{
			int minV=minVertex(wt,visited);
			visited[minV]=true;
			
			for(int j=0;j<n;j++)
			{
				if(a[minV][j]!=0 && !visited[j])
				{
					if(a[minV][j]<wt[j])
					{
						wt[j]=a[minV][j];
						parent[j]=minV;
					}
				}
			}
		}
		
		
		for(int i=1;i<n;i++)
		{
			System.out.println(i+" "+parent[i]+" "+wt[i]);
		}
	}
	
	public static int minVertex(int wt[],boolean visited[])
	{
		
		int vertex=-1;
		
		for(int i=0;i<wt.length;i++)
		{
			if(!visited[i] && (vertex==-1 || wt[i]<wt[vertex]))
			{
				
				vertex=i;
			}
		}
		return vertex;
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
		
		printPrim(a,n);

	}

}
