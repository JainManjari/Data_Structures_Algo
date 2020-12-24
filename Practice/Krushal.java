package Practice;
import java.util.*;
/*
 * 4 4
	0 1 3
	0 3 5
	1 2 1
	2 3 8
 */

class Edge implements Comparable<Edge>
{
	int s;
	int d;
	int wt;
	
	public int compareTo(Edge o)
	{
		return this.wt-o.wt;
	}
}


public class Krushal {
	
	public static int fP(int parent[],int v)
	{
		if(v==parent[v])
		{
			return v;
		}
		return fP(parent,parent[v]);
	}
	
	public static void printKrushal(Edge a[],int n)
	{
		int j=0;
		int count=0;
		Edge out[]=new Edge[n-1];
		int parent[]=new int[n];
		for(int i=0;i<n;i++)
		{
			parent[i]=i;
		}
		
		while(count!=n-1)
		{
			Edge in=a[j];
			int sp=fP(parent,in.s);
			int dp=fP(parent,in.d);
			if(sp!=dp)
			{
				out[count]=in;
				count++;
				parent[dp]=sp;
			}
			j++;
		}
		
		for(int i=0;i<n-1;i++)
		{
			System.out.println(out[i].s+" "+out[i].d+" "+out[i].wt);
		}
	}
	

	public static void main(String[] args) 
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int e=in.nextInt();
		
		Edge a[]=new Edge[e];
		
		for(int i=0;i<e;i++)
		{
			a[i]=new Edge();
			a[i].s=in.nextInt();
			a[i].d=in.nextInt();
			a[i].wt=in.nextInt();
		}
		
		Arrays.sort(a);
		
		printKrushal(a,n);
	}

}
