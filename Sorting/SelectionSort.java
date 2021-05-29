package Sorting;

public class SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[]= {90,20,31,-937,506,0,89,100};
		
		selectionSort(a);
		
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}

	}
	
	
	public static void selectionSort(int a[])
	{
		int n=a.length;
		
		for(int i=0;i<n;i++)
		{
			int minIndex=i;
			int minEle=a[i];
			
			for(int j=i+1;j<n;j++)
			{
				if(a[j]<minEle)
				{
					minEle=a[j];
					minIndex=j;
				}
			}
			
			if(minEle!=a[i])
			{
				int temp=a[i];
				a[i]=a[minIndex];
				a[minIndex]=temp;
			}
		}
	}

}
