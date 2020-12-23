import java.util.*;
public class Inversion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int a[]= {2,4,1,3,5};
		System.out.print(count(a,0,a.length-1));

	}
	
	public static int count(int a[],int start,int last)
	{
		if(start>=last)
		{
			return 0;
		}
		int mid=(start+last)/2;
		int c1=count(a,start,mid);
		int c2=count(a,mid+1,last);
		int c3=c(a,start,mid,last);
		return c1+c2+c3;
	}
	
	public static int c(int a[],int start,int mid,int last)
	{
		int n=mid-start+1;
		int m=last-mid;
		int l[]=new int[n];
		int r[]=new int[m];
		int i1=0;
		int i2=0;
		int ans=0;
		for(int i=start;i<=mid;i++)
		{
			l[i1++]=a[i];
		}
		for(int i=mid+1;i<=last;i++)
		{
			r[i2++]=a[i];
		}
		int index=start;
		int i=0;
		int j=0;
		while(i<n && j<m)
		{
			if(l[i]<r[j])
			{
				a[index++]=l[i];
				i++;
			}
			else
			{
				ans+=(n-i);
				a[index++]=r[j];
				j++;
			}
		}
		while(i<n)
		{
			a[index++]=l[i++];
		}
		while(j<m)
		{
			a[index++]=r[j++];
		}
		return ans;
	}

}
