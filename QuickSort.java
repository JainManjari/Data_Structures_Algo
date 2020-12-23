import java.util.*;
public class QuickSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int a[]= {1,1,3,4,6,7,8,9,10,14,16,20,22,45,78,90,100,110,120,130,150,170,190,200,210,220,234,235,256,276};
		qs(a,0,a.length-1);
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}

	}
	
	public static void qs(int a[],int start,int last)
	{
		if(start>=last)
		{
			return;
		}
		int p=p(a,start,last);
		qs(a,start,p-1);
		qs(a,p+1,last);
	}
	
	public static int p(int a[],int start,int last)
	{
		int pivot=a[start];
		int count=0;
		for(int i=start+1;i<=last;i++)
		{
			if(a[i]<pivot)
			{
				count++;
			}
		}
		int p=start+count;
		a[start]=a[start+count];
		a[start+count]=pivot;
		int i=start;
		int j=last;
		while(i<p && j>p)
		{
			if(a[i]<pivot)
			{
				i++;
			}
			else
			{
				if(a[j]<pivot)
				{
					int t=a[j];
					a[j]=a[i];
					a[i]=t;
					i++;
					j--;
				}
				else
				{
					j--;
				}
			}
		}
		return p;
	}

}
