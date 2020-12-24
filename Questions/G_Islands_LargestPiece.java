package Questions;

import java.util.*;

public class G_Islands_LargestPiece {

	public static void main(String[] args) {
		int a1[][]= {{1,1,0,1},{0,1,0,0},{1,1,0,0},{0,0,0,1}};
		
		System.out.println(largestPiece(a1, a1.length));
		System.out.println(noOfIslands(a1, a1.length));

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
	
	
	
	
	
	
	

}
