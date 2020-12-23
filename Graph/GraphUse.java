package Graph;

import java.util.*;

public class GraphUse {
	
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int edges=in.nextInt();
		int a[][]=new int[n][n];
		for(int i=0;i<edges;i++)
		{
			int fv=in.nextInt();
			int sv=in.nextInt();
			a[fv][sv]=1;
			a[sv][fv]=1;
		}
//		printDFS(a);
//		System.out.println();
//		printBFS(a);
		int startv=in.nextInt();
		int lastv=in.nextInt();
		boolean visit[]=new boolean[a.length];
		System.out.println(isConnected(a));
//		ArrayList<Integer> a1=getPathBFS(a,startv,lastv,visit);
//		if(a1!=null)
//		{
//			for(int i=0;i<a1.size();i++)
//			{
//				System.out.print(a1.get(i)+" ");
//			}
//		}
//		else
//		{
//			System.out.println("No path");
//		}
		//System.out.println(hasPathBFS(a,startv,lastv));
	}
	
	public static void printBFS(int a[][])
	{
		boolean visit[]=new boolean[a.length];
		for(int i=0;i<a.length;i++)
		{
			if(!visit[i])
			{
				printBFSHelper(a,i,visit);
			}
		}
	}
	
	public static boolean isConnected(int a[][])
	{
		System.out.println("start");
		boolean visit[]=new boolean[a.length];
		printBFSHelper2(a,0,visit);
		for(int i=0;i<a.length;i++)
		{
			if(!visit[i])
			{
				return false;
			}
		}
		return true;
	}
	
	private static void printBFSHelper2(int[][] a, int v, boolean[] visit) {
		Queue<Integer> q=new LinkedList();
		q.add(v);
		visit[v]=true;
		while(!q.isEmpty())
		{
			int t=q.remove();
			for(int i=0;i<a.length;i++)
			{
				if(!visit[i] && a[t][i]==1)
				{
					q.add(i);
					visit[i]=true;
				}
			}
		}
	}

	public static ArrayList<Integer> getPathDFS(int a[][],int start,int last,boolean visit[])
	{
		ArrayList<Integer> a1=new ArrayList<Integer>();
		if(start==last)
		{
			a1.add(start);
			return a1;
		}
		visit[start]=true;
		for(int i=0;i<a.length;i++)
		{
			if(!visit[i] && a[start][i]==1)
			{
				ArrayList<Integer> a2=getPathDFS(a,i,last,visit);
				if(a2!=null)
				{
					a2.add(start);
					return a2;
				}
			}
		}
		return null;
	}
	
	public static ArrayList<Integer> getPathBFS(int a[][],int start,int last,boolean visit[])
	{
		ArrayList<Integer> a1=new ArrayList<>();
		if(start==last)
		{
			a1.add(start);
			return a1;
		}
		Queue<Integer> q=new LinkedList<>();
		HashMap<Integer,Integer> map=new HashMap<Integer, Integer>();
		q.add(start);
		visit[start]=true;
		while(!q.isEmpty())
		{
			int t=q.remove();
			if(t==last)
			{
				a1.add(last);
				while(map.get(t)!=start)
				{
					a1.add(map.get(t));
					t=map.get(t);
				}
				a1.add(start);
				return a1;
			}
			for(int i=0;i<a.length;i++)
			{
				if(!visit[i] && a[i][t]==1)
				{
					q.add(i);
					visit[i]=true;
					map.put(i,t);
				}
			}
		}
		return null;
	}
	
	public static boolean hasPathBFS(int a[][],int start,int last)
	{
		if(start==last)
		{
			return true;
		}
		boolean visit[]=new boolean[a.length];
		Queue<Integer> q=new LinkedList<>();
		q.add(start);
		visit[start]=true;
		while(!q.isEmpty())
		{
			int t=q.remove();
			if(t==last)
			{
				return true;
			}
			for(int i=0;i<a.length;i++)
			{
				if(a[i][t]==1 && !visit[i])
				{
					q.add(i);
					visit[i]=true;
				}
			}
		}
		return false;
	}
	
	
	private static void printBFSHelper(int[][] a, int v, boolean[] visit) {
		Queue<Integer> q=new LinkedList<>();
		q.add(v);
		visit[v]=true;
		
		while(!q.isEmpty())
		{
			int t=q.remove();
			System.out.println(t);
			for(int i=0;i<a.length;i++)
			{
				if(!visit[i] && a[t][i]==1)
				{
					q.add(i);
					visit[i]=true;
				}
			}
		}
		
	}

	public static void printDFS(int a[][])
	{
		boolean visit[]=new boolean[a.length];
		for(int i=0;i<a.length;i++)
		{
			if(!visit[i])
			{
				printDFSHelper(a,i,visit);
			}
		}
	}
	
	public static void printDFSHelper(int a[][],int v,boolean visit[])
	{
		visit[v]=true;
		System.out.print(v+" ");
		for(int i=0;i<a.length;i++)
		{
			if(!visit[i] && a[i][v]==1)
			{
				printDFSHelper(a,i,visit);
			}
		}
	}

}
