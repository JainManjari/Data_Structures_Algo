package DP;

public class LIS_Num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[]= {3,2};//{50, 3, 10, 7, 40, 80};//{3, 10, 2, 1, 20};//{10, 22, 9, 33, 21, 50, 41, 60, 80};
		System.out.println(LIS(a));
		

	}
	
	public static int LIS(int a[])
	{
		int LIS[]=new int[a.length];
		
		for(int i=0;i<LIS.length;i++)
		{
			LIS[i]=1;
		}
		
		for(int i=1;i<a.length;i++)
		{
			for(int j=0;j<i;j++)
			{
				if(a[j]<a[i])
				{
					if(LIS[i]<=LIS[j])
					{
						LIS[i]=1+LIS[j];
					}
				}
			}
		}
		
		return LIS[a.length-1];
	}

}
