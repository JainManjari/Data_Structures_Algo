package Sorting;

public class InsertionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {90,20,31,-937,506,0,89,100};
		
		insertionSort(a);
		
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}

	}
	
	public static void insertionSort(int a[])
	{
		int n=a.length;
		
		for(int i=1;i<n;i++)
		{
			int key=a[i];
			int j=i-1;
			
			while(j>=0 && a[j]>key)
			{
				a[j+1]=a[j];
				j--;
			}
			
			a[j+1]=key;
		} 
	}

}
