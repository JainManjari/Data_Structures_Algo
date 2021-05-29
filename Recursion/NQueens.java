package Recursion;
import java.util.*;

public class NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int a[][]=new int[n][n];
		isNQSafe(a, 0, n);
	}
	
	
	public static boolean isSafe(int a[][],int x,int y,int n)
	{
		  int i,j;
		  for(i=0;i<n;i++)
		  {
			  if(a[x][i]==1)
			  {
				  return false;
			  }
		  }
		  
		  for(i=0;i<n;i++)
		  {
			  if(a[i][y]==1)
			  {
				  return false;
			  }
		  }
		  
		  for(i=x, j=y;i>=0 && j>=0;i--,j--)
		  {
			    if(a[i][j]==1)
			    {
			    	return false;
			    }
		  }
		  
		  for(i=x,j=y;i<n && j>=0;i++,j--)
		  {
			  if(a[i][j]==1)
			  {
				  return false;
			  }
		  }
		  
		  return true;
	}
	
	
	public static boolean isNQSafe(int a[][],int col,int n)
	{
		if(col>=n)
		{
			print(a,n);
			return true;
		}
		
		for(int i=0;i<n;i++)
		{
			if(isSafe(a,i,col,n))
			{
				a[i][col]=1;
				
				if(isNQSafe(a, col+1, n))
				{
					return true;
				}
				
				a[i][col]=0;
			}
		}
		return false;
	}
	
	
	
	
	public static void print(int a[][],int n)
	{
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
		}
	}

}
