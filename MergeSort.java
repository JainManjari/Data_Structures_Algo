import java.util.*;
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int a[]= {4,3,2,1,8,6,3,2,1};
		sort(a,0,a.length-1);
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}

	}
	
	public static void sort(int a[],int start,int last)
	{
		if(start>=last)
		{
			//System.out.println(start+" "+last);
			return;
		}
		//System.out.println(start+" "+last);
		//System.out.println(start+);
		int mid=(last+start)/2;
		sort(a,start,mid);
		sort(a,mid+1,last);
		merge(a,start,mid,last);
		
	}
	
	public static void merge(int a[],int start,int mid,int last)
	{
		int n=mid-start+1;
		int m=last-mid;
		int l[]=new int[n];
		int r[]=new int[m];
		int i1=0;
		int i2=0;
		//System.out.print("L ");
		for(int i=start;i<=mid;i++)
		{
			l[i1]=a[i];
			//System.out.print(l[i1]+" ");
			i1++;
		}
		//System.out.print("R ");
		for(int i=mid+1;i<=last;i++)
		{
			r[i2]=a[i];

			//System.out.print(r[i2]+" ");
			i2++;
		}
		//ystem.out.println();
		int i=0;
		int j=0;
		int index=start;
		while(i<n && j<m)
		{
			if(l[i]>r[j])
			{
				a[index]=r[j];
				j++;
			}
			else 
			{
				a[index]=l[i];
				i++;
			}
			//System.out.print(a[index]+" ");
			index++;
		}
		//sSystem.out.println();
		while(i<n)
		{
			a[index]=l[i];
			index++;
			i++;
		}
		while(j<m)
		{
			a[index]=r[j];
			index++;
			j++;
		}
	}
	

}
