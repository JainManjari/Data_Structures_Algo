package Questions;
import java.util.*;

public class Sudoku {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
//		int a[][]=new int[9][9];
//		
//		for(int i=0;i<9;i++)
//		{
//			for(int j=0;j<9;j++)
//			{
//				a[i][j]=in.nextInt();
//			}
//		}
		int a[][]={ { 3, 0, 6, 5, 0, 8, 4, 0, 0 },
                { 5, 2, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 8, 7, 0, 0, 0, 0, 3, 1 },
                { 0, 0, 3, 0, 1, 0, 0, 8, 0 },
                { 9, 0, 0, 8, 6, 3, 0, 0, 5 },
                { 0, 5, 0, 0, 9, 0, 6, 0, 0 },
                { 1, 3, 0, 0, 0, 0, 2, 5, 0 },
                { 0, 0, 0, 0, 0, 0, 0, 7, 4 },
                { 0, 0, 5, 2, 0, 6, 3, 0, 0 } };
		
		solve(a, 0, 0);
		for(int i=0;i<9;i++)
		{
			for(int j=0;j<9;j++)
			{
				System.out.print(a[i][j]+" ");
			}
			System.out.println();
	   }
	}
	
	public static boolean rowSearch(int a[][],int row,int num)
	{
		
		for(int j=0;j<9;j++)
		{
			if(a[row][j]==num)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean colSearch(int a[][],int col,int num)
	{
		
		for(int i=0;i<9;i++)
		{
			if(a[i][col]==num)
			{
				return false;
			}
		}
		
		return true;
	}
	
	public static boolean gridSearch(int a[][],int row,int col,int num)
	{
		int ans1=row%3;
		int ans2=col%3;
		int startX=row-ans1;
		int startY=col-ans2;
		int endX=row;
		int endY=col;
		
		if(ans1==0)
		{
			endX+=2;
		}
		else if(ans1!=2)
		{
			endX+=ans1;
		}
		if(ans2==0)
		{
			endY+=2;
		}
		else if(ans2!=2)
		{
			endY+=ans2;
		}
		
		for(int i=startX;i<=endX;i++)
		{
			for(int j=startY;j<=startY;j++)
			{
				if(a[i][j]==num)
				{
					return false;
				}
			}
		}
		
		
		return true;
	}
	
	public static boolean solve(int a[][],int row,int col)
	{
		if(row==8 && col==9)
		{
			return true;
		}
		if(col==9)
		{
			row=row+1;
			col=0;
		}
		//System.out.println(row+" "+col+" "+a[row][col]);
		if(a[row][col]!=0)
		{
			
			return solve(a,row,col+1);
		}
		
		for(int i=1;i<=9;i++)
		{
			if(rowSearch(a, row, i) && colSearch(a, col, i) && gridSearch(a, row, col, i))
			{
				//System.out.println("num select "+row+" "+col+" "+i);
				a[row][col]=i;
				if(solve(a,row,col+1))
				{
					return true;
				}
	
			}
			a[row][col]=0;
		}
		
		return false;
		
	}

}
