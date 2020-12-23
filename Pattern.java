import java.util.*;
public class Pattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		int a[][]=new int[n][n];
		if(n%2!=0)
		{
			int index=0;
			for(int j=1;j<=n;j=j+2)
			{
				a[index][n-1]=j*n;
				//System.out.println(index+" "+a[index][n-1]);
				for(int k=n-2;k>=0;k--)
				{
					a[index][k]=a[index][k+1]-1;
				}
				index++;
			}
			//System.out.println(index);
			for(int j=n-1;j>=2;j=j-2)
			{
				a[index][n-1]=j*n;
				for(int k=n-2;k>=0;k--)
				{
					a[index][k]=a[index][k+1]-1;
				}
				index++;
			}
		}
		else
		{
			int index=0;
			for(int j=1;j<n;j=j+2)
			{
				a[index][n-1]=j*n;
				for(int k=n-2;k>=0;k--)
				{
					a[index][k]=a[index][k+1]-1;
				}
				index++;	
			}
			for(int j=n;j>=2;j=j-2)
			{
				a[index][n-1]=j*n;
				for(int k=n-2;k>=0;k--)
				{
					a[index][k]=a[index][k+1]-1;
				}
				index++;
			}
		}
        
		
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
