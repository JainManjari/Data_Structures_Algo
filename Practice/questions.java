package Practice;
import java.util.*;
import java.util.LinkedList;
import java.util.LinkedHashMap;

class Coor
{
	int x;
	int y;
	
	public Coor(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
}

class Syno
{
	String a;
	String b;
}

public class questions {
	
	
	
	
	
	
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int a[]= {-10,-20,-30,-40,0,0,0};
		//System.out.println(secondLargest(a));
		
//		String Graph[]= {"DANDO","NNINJ","AXGJC","INJAA","CODDI"};
//		int N=5;
//		int M=5;
//		
//		System.out.println(solve(Graph,N,M));
		
//		int a1[][]= {{1,1,0,1},{0,1,0,0},{1,1,0,0},{0,0,0,1}};
//		
//		System.out.println(largestPiece(a1, a1.length));
//		System.out.println(noOfIslands(a1, a1.length));
		
		
		//         0,1,2,3,4,5,6,7,8,9
//		int a2[]= {4,5,6,7,8,9,10,1,2,3};
//		int K=1;
//		System.out.println(find(a2,0,a2.length-1,K));
		
		
//		int a3[][]={ {2, 1, 0, 2, 1},
//                {0, 0, 1, 2, 1},
//                {1, 0, 0, 2, 1}};
//		
//		System.out.println(findTime(a3));
		
		
	
		
		/*
		 * 
		 *  7
			ram shyam 
			sita gita
			ram rahul
			rahul karan
			rahul vaibhav
			shyam mansi
			mansi jhansi
		 */
		
		// no of pairs for a syn class
		int n=in.nextInt();
		ArrayList<Syno> a4=new ArrayList<Syno>();
		
		for(int i=0;i<n;i++)
		{
			Syno c=new Syno();
			c.a=in.next();
			c.b=in.next();
			a4.add(c);
		}
		
		LinkedHashMap<String,Integer> map=new LinkedHashMap();
		LinkedHashMap<Integer,String> map2=new LinkedHashMap();
		
		int count=0;
		
		for(int i=0;i<a4.size();i++)
		{
			if(!map.containsKey(a4.get(i).a))
			{
				map.put(a4.get(i).a,count);
				map2.put(count,a4.get(i).a);
				count++;
			}
			if(!map.containsKey(a4.get(i).b))
			{
				map.put(a4.get(i).b,count);
				map2.put(count,a4.get(i).b);
				count++;
			}
		}
		
		
//		for(String key:map.keySet())
//		{
//			System.out.println(key+" "+map.get(key));
//		}
		
		int parent[]=new int[count];
		
		for(int i=0;i<parent.length;i++)
		{
			parent[i]=i;
		}
		
		for(int i=0;i<a4.size();i++)
		{
			Syno c=a4.get(i);
			int index_b=map.get(c.b);
			int index_a=map.get(c.a);
			parent[index_b]=index_a;
		}
		
		for(int i=0;i<parent.length;i++)
		{
			System.out.println(i+"("+map2.get(i)+") "+parent[i]+"("+map2.get(parent[i])+")");
		}

		
		//the word to find syno
		String word="karan";
		
		if(map.containsKey(word))
		{
			boolean visited[]=new boolean[parent.length];
			
			int index=fP(parent,map.get(word));
			
			printNamesBetter(parent,index,map2,visited,word);
		}
		else
		{
			System.out.println("Word doesn't exits!");
		}
		
	}
	
	
	public static void printNamesBetter(int parent[],int index,LinkedHashMap<Integer,String> map,boolean visited[],String word)
	{
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(index);
		q.add(-1);
		
		while(!q.isEmpty())
		{
			while(!q.isEmpty() && q.peek()!=-1)
			{
				int t=q.remove();
				visited[t]=true;
				if(!map.get(t).equals(word))
				{
					System.out.print(map.get(t)+" ");
				}
				for(int i=0;i<parent.length;i++)
				{
					if(parent[i]==t && !visited[i])
					{
						q.add(i);
					}
				}
			}
			q.remove();
			q.add(-1);
			if(q.peek()==-1)
			{
				q.remove();
			}
		}
	}
	
	public static void printNames(int parent[],int index,LinkedHashMap<Integer,String> map,boolean visited[],String word)
	{

		visited[index]=true;
		if(!map.get(index).equals(word))
		{
			System.out.print(map.get(index)+" ");
		}
		for(int i=0;i<parent.length;i++)
		{
			if(parent[i]==index && !visited[i])
			{
				printNames(parent,i,map,visited,word);
			}
		}
	}
	
	
	public static int fP(int parent[],int v)
	{
		if(parent[v]==v)
		{
			return v;
		}
		return fP(parent,parent[v]);
	}
	
	
	
	
	
	
	
	
	
	public static boolean isSafe(int row,int col,int n,int m)
	{
		if(row>=n || col>=m || row<0 || col<0)
		{
			return false;
		}	
		return true;
	}
	
	
	public static boolean check(int a[][],int n,int m)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(a[i][j]==1)
				{
					return true;
				}
			}
		}
		return false;
	}
	
	public static int findTime(int a[][])
	{
		int time=0;
		
		int n=a.length; // no of rows
		int m=a[0].length; //no of columns
		
		
		Queue<Coor> q=new LinkedList<>();
		
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<m;j++)
			{
				if(a[i][j]==2)
				{
					Coor c=new Coor(i,j);
					q.add(c);
				}
			}
		}
		
		//Adding delimiter
		Coor c=new Coor(-1,-1);
		q.add(c);
		
		while(!q.isEmpty())
		{
			boolean flag=false;
			while(!q.isEmpty() && q.peek()!=c)
			{
				Coor t=q.remove();
				
				if(isSafe(t.x+1, t.y, n, m) && a[t.x+1][t.y]==1)
				{
					a[t.x+1][t.y]=2;// important for checkArray() boolean function
					Coor e=new Coor(t.x+1,t.y);
					q.add(e);
					if(!flag)
					{
						flag=true;
						time++;
					}
				}
				
				if(isSafe(t.x, t.y+1, n, m) && a[t.x][t.y+1]==1)
				{
					a[t.x][t.y+1]=2;
					Coor e=new Coor(t.x,t.y+1);
					q.add(e);
					if(!flag)
					{
						flag=true;
						time++;
					}
				}
				if(isSafe(t.x-1, t.y, n, m) && a[t.x-1][t.y]==1)
				{
					a[t.x-1][t.y]=2;
					Coor e=new Coor(t.x-1,t.y);
					q.add(e);
					if(!flag)
					{
						flag=true;
						time++;
					}
				}
				if(isSafe(t.x, t.y-1, n, m) && a[t.x][t.y-1]==1)
				{
					a[t.x][t.y-1]=2;
					Coor e=new Coor(t.x,t.y-1);
					q.add(e);
					if(!flag)
					{
						flag=true;
						time++;
					}
				}
			}
			q.remove();
			q.add(c);
			if(q.peek()==c)
			{
				q.remove();
			}
		}
			
		
		
		return (check(a, n, m))?-1:time;
	}
	

	
	
	
	
	
	
	
	public static int find(int a[],int s,int e,int ele)
	{
		if(s>e)
		{
			return -1;
		}
		
		
		int mid=(s+e)/2;
		
		//System.out.println("index "+s+" "+e+" "+mid);
		
		if(a[mid]==ele)
		{
			return mid;
		}
		
		if(a[s]<=a[mid])
		{
			if(a[s]<= ele && ele<=a[mid])
			{
				return find(a,s,mid-1,ele);
			}
			return find(a,mid+1,e,ele);
		}
		
		if(ele>=a[mid] && ele<=a[e])
		{
			return find(a,mid+1,e,ele);
		}
		return find(a,s,mid-1,ele);
		
	}
	
	
	
	
	
	
	
	public static int secondLargest(int a[])
	{
		int sec=Integer.MIN_VALUE;
		int larg=Integer.MIN_VALUE;
		
		for(int i=0;i<a.length;i++)
		{
			if(a[i]>larg)
			{
				sec=larg;
				larg=a[i];
			}
			else if(sec<a[i] && a[i]<larg)
			{
				sec=a[i];
			}
		}
		
		return sec;
	}
	
	
	
	
	
	
	
	
	public static int largestPiece(int a[][],int n)
	{
		boolean visited[][]=new boolean[n][n];
		
		int max=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(a[i][j]==1 && !visited[i][j])
				{
					
					int ans=largestPieceHelper(a, i, j, n, visited);
					if(max<ans)
					{
						max=ans;
					}
				}
			}
		}
		
		return max;
	}
	
	public static int largestPieceHelper(int a[][],int row,int col, int n,boolean visited[][])
	{
		if(row>=n || col>=n || row<0 || col<0)
		{
			return 0;
		}
		
		if(a[row][col]==1 && !visited[row][col])
		{
			visited[row][col]=true;
			int length=1+(largestPieceHelper(a, row, col+1, n, visited)+
					      largestPieceHelper(a, row+1, col, n, visited)+largestPieceHelper(a, row, col-1, n, visited)
					      +largestPieceHelper(a, row-1, col, n, visited));
			
			return length;
		}
		
		return 0;
		
	}
	
	
	
	
	
	
	
	
	public static int noOfIslands(int a[][],int n)
	{
		boolean visited[][]=new boolean[n][n];
		
		int count=0;
		
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(a[i][j]==1 && !visited[i][j])
				{
					
					count+=noOfIslandsHelper(a, i, j, n, visited);
					
				}
			}
		}
		
		return count;
	}
	
	
	public static int noOfIslandsHelper(int a[][],int row,int col, int n,boolean visited[][])
	{
		if(row>=n || col>=n || row<0 || col<0)
		{
			return 0;
		}
		
		if(a[row][col]==1 && !visited[row][col])
		{
			visited[row][col]=true;
			int length=(noOfIslandsHelper(a, row, col+1, n, visited)+
					    noOfIslandsHelper(a, row+1, col, n, visited)+noOfIslandsHelper(a, row, col-1, n, visited)
					    +noOfIslandsHelper(a, row-1, col, n, visited)+noOfIslandsHelper(a, row+1, col+1, n, visited)
					    +noOfIslandsHelper(a, row+1, col-1, n, visited)+noOfIslandsHelper(a, row-1, col-1, n, visited)
					    +noOfIslandsHelper(a, row-1, col+1, n, visited));
			
			return 1;
		}
		
		return 0;
		
	}
	
	
	
	
	
	
	
	public static int solve(String[] Graph , int N, int M)
	{
        
        Character a[][]=new Character[N][M];
        boolean visited[][]=new boolean[N][M];
        
        String s="CODINGNINJA";
        
        for(int i=0;i<N;i++)
        {
            String s1=Graph[i];
            for(int j=0;j<M;j++)
            {
                a[i][j]=s1.charAt(j);
            }
        }
        
        
        for(int i=0;i<N;i++)
        {
            for(int j=0;j<M;j++)
            {
                if(a[i][j]==s.charAt(0))
                {
                    visited=new boolean[N][M];
                    //System.out.println("index "+i+" "+j);
                    boolean ans=sol(a,i,j,s,N,M,visited);
                    //System.out.println("ans "+ans);
                    if(ans)
                    {
                        return 1;
                    }
                }
            }
        }
     
        
        
        return 0;
	}
    
    public static boolean sol(Character a[][],int row,int col,String s,int N,int M,boolean visited[][])
    {
        //System.out.println("sol ind "+row+" "+col+" "+M+" "+N);
        if(row>=N || col>=M || row<0 || col<0)
        {
            return false;
        }
        
        //System.out.println("ele "+a[row][col]+" "+visited[row][col]);
        
        if(a[row][col]==s.charAt(0) && s.length()==1 && !visited[row][col])
        {
            return true;
        }
        
        if(a[row][col]==s.charAt(0) && !visited[row][col])
        {
            visited[row][col]=true;
            boolean ans=false;
            
            ans = ans || (sol(a,row,col+1,s.substring(1),N,M,visited) || sol(a,row+1,col+1,s.substring(1),N,M,visited)
                          || sol(a,row+1,col,s.substring(1),N,M,visited) || sol(a,row+1,col-1,s.substring(1),N,M,visited)
                          || sol(a,row,col-1,s.substring(1),N,M,visited) || sol(a,row-1,col-1,s.substring(1),N,M,visited)
                          || sol(a,row-1,col,s.substring(1),N,M,visited) || sol(a,row-1,col+1,s.substring(1),N,M,visited)
                         );
           return ans;
            
        }
        
        return false;
    }
	
        
}
