package Heap;

public class MintoMaxHeap {
	
	public static void insertMin(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			insertMinHelper(a,i);
		}
		
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
	}
	
	private static void insertMinHelper(int a[],int cI)
	{
		while(cI>0)
		{
			int pI=(cI-1)/2;
			
			if(a[cI]<a[pI])
			{
				int temp=a[cI];
				a[cI]=a[pI];
				a[pI]=temp;
				cI=pI;
			}
			else
			{
				break;
			}
		}
	}
	
	public static void mintomax(int a[])
	{
		for(int i=((a.length-1)/2);i>=0;i--)
		{
			//System.out.println("pI "+i);
			mintomaxhelper(a,i);
		}
	}
	
	private static void mintomaxhelper(int a[],int pI)
	{
		int lI=2*pI+1;
		int rI=2*pI+2;
		
		int maxI=pI;
		
		
		if(lI<a.length && a[lI]>a[maxI])
		{
			maxI=lI;
		}
		
		if(rI<a.length && a[rI]>a[maxI])
		{
			maxI=rI;
		}
		if(maxI!=pI)
		{
			int t=a[pI];
			a[pI]=a[maxI];
			a[maxI]=t;
			mintomaxhelper(a,maxI);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        int a[]= {2 ,6 ,8 ,5 ,4 ,3};
		insertMin(a);
		
		mintomax(a);
		
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();

	}

}















