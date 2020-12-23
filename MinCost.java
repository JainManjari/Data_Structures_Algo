import java.util.*;
public class MinCost {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int a[][]= {{1,3,1},{1,5,1},{4,2,1}};
		int a1[][]=new int[a.length][a[0].length];
		
        System.out.print(min(a,a1,a.length-1,a[0].length-1));
	}
	
	public static int min(int a[][],int a1[][],int i,int j)
	{
		if(i<0)
		{
			return 0;
		}
		a1[i][j]=a[i][j];
		for(int k=j-1;k>=0;k--)
		{
			a1[i][k]=a1[i][k+1]+a[i][k];
		}
		for(int k=i-1;k>=0;k--)
		{
			a1[k][j]=a1[k+1][j]+a[k][j];
		}
		
		for(int k1=i-1;k1>=0;k1--)
		{
			for(int k2=j-1;k2>=0;k2--)
			{
				a1[k1][k2]=Math.min(a1[k1+1][k2+1],Math.min(a1[k1][k2+1], a1[k1+1][k2]))+a[k1][k2];
			}
		}
		return a1[0][0];
	}

}
