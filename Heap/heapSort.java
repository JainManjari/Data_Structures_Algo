package Heap;



public class heapSort {
	
	public static void insertMax(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			insertHelperMax(a,i);
		}
		
//		for(int i=0;i<a.length;i++)
//		{
//			System.out.print(a[i]+" ");
//		}
//		System.out.println();
		int index=0;
		for(int i=a.length-1;i>=0;i--)
		{
			a[i]=removeMax(a,a.length-index);
			//System.out.println("Remove max "+a[i]+" ");
			index++;
		}
		//System.out.println();
	}
	
	
	//Max Heap
	public static void insertHelperMax(int a[],int cI)
	{
		
		while(cI!=0)
		{
			int pI=(cI-1)/2;
			
			if(a[cI]>a[pI])
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
	
	public static int removeMax(int a[],int n)
	{
		int temp=a[0];
		
		a[0]=a[n-1];
		int len=n-2;
		int pI=0;
		int lI=2*pI+1;
		int rI=2*pI+2;
		
		//System.out.println("len "+len);
		
		while(lI<=len)
		{
			//System.out.println("parent "+a[pI]+" "+a[lI]+" "+a[rI]);
			int maxI=pI;
			
			if(a[lI]>a[maxI])
			{
				//System.out.println("left greater");
				maxI=lI;
			}
			
			if(rI<=len && a[rI]>a[maxI])
			{
				//System.out.println("right greater");
				maxI=rI;
			}
			
			
			if(maxI!=pI)
			{
				
				int t=a[pI];
				a[pI]=a[maxI];
				a[maxI]=t;
				//System.out.println("max ele "+a[maxI]+" "+a[pI]);
				pI++;
				lI=2*pI+1;
				rI=2*pI+2;
				
			}
			else
			{
				break;
			}
		}
//		
//		for(int i=0;i<=len;i++)
//		{
//			System.out.print(a[i]+" ");
//		}
//		System.out.println();
		
		return temp;
	}
	
	public static void insertMin(int a[])
	{
		for(int i=0;i<a.length;i++)
		{
			insertHelperMin(a,i);
		}
		
		int index=0;
		
		for(int i=a.length-1;i>=0;i--)
		{
			a[i]=removeMin(a,a.length-index);
			index++;
		}
	}
	
	public static void insertHelperMin(int a[],int cI)
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
	
	public static int removeMin(int a[],int n)
	{
		int temp=a[0];
		a[0]=a[n-1];
		int len=n-2;
		int pI=0;
		int lI=2*pI+1;
		int rI=2*pI+2;
		
		while(lI<=len)
		{
			int minI=pI;
			
			if(a[lI]<a[minI])
			{
				minI=lI;
			}
			if(rI<=len && a[rI]<a[minI])
			{
				minI=rI;
			}
			
			if(minI!=pI)
			{
				int t=a[pI];
				a[pI]=a[minI];
				a[minI]=t;
				pI++;
				lI=2*pI+1;
				rI=2*pI+2;
			}
			else
			{
				break;
			}
		}
		
		return temp;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {2 ,6 ,8 ,5 ,4 ,3};
		
		//Sorting in ascending order
		insertMax(a);
		
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();
		
		int a1[]= {2 ,6 ,8 ,5 ,4 ,3};
		
		//Sorting in descending order
		insertMin(a1);
		
		for(int i=0;i<a1.length;i++)
		{
			System.out.print(a1[i]+" ");
		}
		System.out.println();
	}

}
