import java.util.*;
public class ShuffeArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		int a[]= {0,5,3,2,1};
		rand(a,a.length-1);
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}

	}
	
	public static void rand(int a[],int n)
	{
		Random r=new Random();
		for(int i=n;i>0;i--)
		{
			int j=r.nextInt(i+1);
			int temp=a[i];
			a[i]=a[j];
			a[j]=temp;
		}
	}

}
