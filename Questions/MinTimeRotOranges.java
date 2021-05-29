package Questions;

import java.util.*;
import java.util.LinkedList;

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

public class MinTimeRotOranges {
	
	public static void main(String args[])
	{
		int a3[][]={ {2, 1, 0, 2, 1},
                     {0, 0, 1, 2, 1},
                     {1, 0, 0, 2, 1}};
		
		System.out.println(findTime(a3));
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
	



}

