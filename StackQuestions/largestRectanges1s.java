package StackQuestions;
import java.util.*;


public class largestRectanges1s {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[][]= {{0,1,1,0},
		            {1,1,1,1},
		            {1,1,1,1},
		            {1,1,0,0}};
		
		int C=a.length;
		int R=a[0].length;
		
		System.out.println(largestRect(a, R, C));

	}
	
	public static int largestRect(int mat[][],int R,int C)
	{
		int res=largestHistogram.largestHist(mat[0], R);
		
		for(int i=1;i<R;i++)
		{
			for(int j=0;j<C;j++)
			{
				if(mat[i][j]==1)
				{
					mat[i][j]+=mat[i-1][j];
				}
			}
			res=Math.max(res,largestHistogram.largestHist(mat[i], R));
		}
		
		
		return res;
	}

}
