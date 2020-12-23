package Graph;

import java.util.*;

class Edge implements Comparable<Edge>
{
	int start;
	int weight;
	int last;
	@Override
	
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return this.weight-o.weight;
	}
	
	
	
}

public class Krushal {
	
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int e=in.nextInt();
		Edge a[]=new Edge[e];
		for(int i=0;i<e;i++)
		{
			a[i]=new Edge();
			a[i].start=in.nextInt();
			a[i].last=in.nextInt();
			a[i].weight=in.nextInt();
		}
		Krushal(a,n);
	}

	private static void Krushal(Edge a[],int n) {
		Arrays.sort(a);
		int parent[]=new int[a.length];
		for(int i=0;i<a.length;i++)
		{
			parent[i]=i;
		}
		int count=0;
		Edge out[]=new Edge[n-1];
		int k=0;
		while(count!=n-1)
		{
			Edge curr=a[k];
			int sp=fP(curr.start,parent);
			int lp=fP(curr.last,parent);
			if(sp!=lp)
			{
				out[count]=curr;
				count++;
				k++;
				parent[sp]=lp;
			}
		}
		for(int i=0;i<out.length;i++)
		{
			System.out.println(out[i].start+" "+out[i].last+" "+out[i].weight);
		}
		
	}

	private static int fP(int start, int parent[]) {
		if(parent[start]==start)
		{
			return start;
		}
		return fP(parent[start],parent);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
