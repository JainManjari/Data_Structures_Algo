package Practice;
import java.util.*;
import java.util.LinkedList;

public class Graph {
	
	
	public static void printDFS(int a[][])
	{
		boolean visited[]=new boolean[a.length];
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				if(!visited[i])
				{
					printDFSHelper(a,i,visited);
				}
			}
		}
	}
	
	private static void printDFSHelper(int a[][],int vector,boolean visited[])
	{
		visited[vector]=true;
		System.out.print(vector+" ");
		
		for(int i=0;i<a.length;i++)
		{
			if(a[vector][i]==1 && !visited[i])
			{
				printDFSHelper(a, i, visited);
			}
		}
	}

	public static void printBFS(int a[][])
	{
		boolean visited[]=new boolean[a.length];
		
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a.length;j++)
			{
				if(!visited[i])
				{
					printBFSHelper(a,i,visited);
				}
			}
		}
		
	}
	
	private static void printBFSHelper(int a[][],int vector,boolean visited[])
	{
		Queue<Integer> q=new LinkedList<Integer>();
		visited[vector]=true;
		q.add(vector);
		
		while(!q.isEmpty())
		{
			vector=q.remove();
			System.out.print(vector+" ");
			for(int j=0;j<a.length;j++)
			{
				if(a[vector][j]==1 && !visited[j])
				{
					q.add(j);
					visited[j]=true;
				}
			}
		}
	}
	
	public static boolean hasPathDFS(int a[][],int sv,int lv)
	{
		boolean visited[]=new boolean[a.length];
		
		return hasPathDFSHelper(a, sv, lv, visited);
	}
	
	private static boolean hasPathDFSHelper(int a[][],int sv,int lv,boolean visited[])
	{
		if(sv==lv)
		{
			return true;
		}
	
		visited[sv]=true;
		
		boolean ans=false;
		
		for(int j=0;j<a.length;j++)
		{
			if(a[sv][j]==1 && !visited[j])
			{
				ans=ans | hasPathDFSHelper(a,j,lv,visited);
			}
		}
		return ans;
		
	}
	
	
	public static boolean hasPathBFS(int a[][],int sv,int lv)
	{
		if(sv==lv)
		{
			return true;
		}
		boolean visited[]=new boolean[a.length];
		Queue<Integer> q=new LinkedList();
		visited[sv]=true;
		q.add(sv);
		
		while(!q.isEmpty())
		{
			int t=q.remove();
			if(t==lv)
			{
				return true;
			}
			for(int j=0;j<a.length;j++)
			{
				if(a[t][j]==1 && !visited[j])
				{
					q.add(j);
					visited[j]=true;
				}
			}
		}
		
		return false;
		
	}
	
	public static ArrayList<Integer> getPathDFS(int a[][],int sv,int lv)
	{
		boolean visited[]=new boolean[a.length];
		ArrayList<Integer> a1 =new ArrayList();

		
		return getPathDFSHelper(a,sv,lv,visited,a1);
	}
	
	private static ArrayList<Integer> getPathDFSHelper(int a[][],int sv,int lv, boolean visited[], ArrayList<Integer> path)
	{			
		if(sv==lv)
		{
			ArrayList<Integer> a1=new ArrayList<Integer>();
			a1.add(lv);
			for(int i=0;i<path.size();i++)
			{
				a1.add(path.get(i));
			}
			return a1;
		}
		ArrayList<Integer> a1=new ArrayList<Integer>();
		a1.add(sv);
		for(int i=0;i<path.size();i++)
		{
			a1.add(path.get(i));
		}
		visited[sv]=true;
		
		for(int j=0;j<a.length;j++)
		{
			if(a[sv][j]==1 && !visited[j])
			{
				ArrayList<Integer> a2=getPathDFSHelper(a,j,lv, visited, a1);
				if(a2!=null)
				{
					return a2;
				}
			}
		}
		return null;
		
	}
	
	public static ArrayList<Integer> getPathBFS(int a[][],int sv,int lv)
	{
		boolean visited[]=new boolean[a.length];
		
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(sv);
		visited[sv]=true;
		
		LinkedHashMap<Integer,Integer> map=new LinkedHashMap<Integer, Integer>();
		
		while(!q.isEmpty())
		{
			int t=q.remove();
			if(t==lv)
			{
				ArrayList<Integer> a1=new ArrayList<Integer>();
				a1.add(lv);
				
				while(map.get(lv)!=sv)
				{
					a1.add(map.get(lv));
					lv=map.get(lv);
				}
				
				a1.add(sv);
				
				return a1;
			}
			for(int j=0;j<a.length;j++)
			{
				if(a[t][j]==1 && !visited[j])
				{
					q.add(j);
					visited[j]=true;
					map.put(j, t);
				}
			}
		}
		
	
		return null;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
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
			a[fv][sv]=1;
			a[sv][fv]=1;
		}
		
		System.out.println("DFS Transversal");
		printDFS(a);
		
		System.out.println();
		
		System.out.println("BFS Transversal");
		printBFS(a);
		
		System.out.println();
	}

}
