package DP;

import java.util.*;

class p
{
	int x;
	int y;
	
	public p(int x,int y)
	{
		this.x=x;
		this.y=y;
	}
	
}

public class qq {
	
	
	
	public static boolean isSafe(int row,int col,int n,int m)
	{
		if(row>=n || col>=m || row<0 || col<0)
		{
			return false;
		}
		return true;
	}
	
	
	 public static int minimumDistance(int area[][]) {
		    // Write your code here
		        int n=area.length;
		        
		        int m=area[0].length;
		        //int a[][]=new int[n][];
		        boolean visited[][]=new boolean[n][m];
		        
		        
	            int min=-1;
//		        
//		        p p1=new p(0,0);
//		        p p2=new p(-1,-1);
//		        
//		        Queue<p> q=new LinkedList<>();
//		        q.add(p1);
//		        q.add(p2);
//		        
//		        while(!q.isEmpty())
//		        {
//		        	while(!q.isEmpty() && q.peek()!=p2)
//		        	{
//		        		p p=q.remove();
//			        	
//		        		if(area[p.x][p.y]==9 && !visited[p.x][p.y])
//			        	{
//			        		visited[p.x][p.y]=true;
//			        		break;
//			        	}
//		        		
//		        		else if(area[p.x][p.y]==1 && !visited[p.x][p.y])
//			        	{
//			        		visited[p.x][p.y]=true;
//			        		
//			        		if(isSafe(p.x+1,p.y,n,m) && area[p.x+1][p.y]==1)
//			        		{
//			        			p p3=new p(p.x+1,p.y);
//			        			q.add(p3);
//			        		}
//			        		if(isSafe(p.x,p.y+1,n,m) && area[p.x][p.y+1]==1)
//			        		{
//			        			p p3=new p(p.x,p.y+1);
//			        			q.add(p3);
//			        		}
//			        		if(isSafe(p.x-1,p.y,n,m) && area[p.x-1][p.y]==1)
//			        		{
//			        			p p3=new p(p.x-1,p.y);
//			        			q.add(p3);
//			        		}
//			        		if(isSafe(p.x,p.y-1,n,m) && area[p.x][p.y-1]==1)
//			        		{
//			        			p p3=new p(p.x,p.y-1);
//			        			q.add(p3);
//			        		}
//			        	}
//		        	}
//		        	q.remove();
//		        	q.add(p2);
//		        	if(min==-1)
//		        	{
//		        		min=0;
//		        	}
//		        	min++;
//		        	if(q.peek()==p2)
//		        	{
//		        		q.remove();
//		        	}
//		        
//		        }
		        
		        
		        return dist(area,visited,0,0,n,m);
		        
		        
		    }
		    
		    public static int dist(int area[][], boolean visited[][], int row,int col,int n,int m)
		    {
		    	System.out.println("index "+row+" "+col);
		        if(row>=n || col>=m || row<0 || col<0)
		        {
		            return Integer.MAX_VALUE;
		        }
		        
		        if(area[row][col]==9 && !visited[row][col])
		        {
		            visited[row][col]=true;
		            return 0;
		        }
		        
		        if(area[row][col]==1 && !visited[row][col])
		        {
		        	System.out.println("1 ");
		            visited[row][col]=true;
		            int op1=dist(area,visited, row,col+1,n,m);
		            int op2=dist(area,visited, row+1,col,n,m);
		            int op3=dist(area,visited, row,col-1,n,m);
		            int op4=dist(area,visited, row-1,col,n,m);
		            int ans=Math.min(op1,Math.min(op2,Math.min(op3,op4)));
		            System.out.println(op1+" "+op2+" "+op3+" "+op4+" "+ans+" "+(ans+1));
		            //visited[row][col]=false;
		            if(ans==Integer.MAX_VALUE)
		            {
		            	return -1;
		            }
		           
		            return 1+Math.min(op1,Math.min(op2,Math.min(op3,op4)));
		        }
		        return Integer.MAX_VALUE;
		    }    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[][]= {{1,1,1,1},{0,1,1,1},{0,1,0,1},{1,1,0,1},{0,9,1,1}};
		
		
		
		System.out.println(minimumDistance(a));
		
		
	}
	
	public static int Sq(int n)
    {
//        if(n==0 || n==1)
//        {
//            return n;
//        }
//        int s=1;
//        int ans=1;
//        
//        while(ans<=n)
//        {
//            s++;
//            ans=s*s;
//        }
//        return s-1;
        
         int s=1;
        int e=n;
         int ans=0;
        
        while(s<=e)
        {
             int mid=(s+e)/2;
            
             if(mid*mid==n)
             {
                 return mid;
             }
            
             if(mid*mid<n)
             {
                 s=mid+1;
                 ans=mid;
             }
             else
             {
                 e=mid-1;
             }
         }
        return ans;
    }

}
