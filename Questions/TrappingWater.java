package Questions;
import java.util.*;

public class TrappingWater {
	
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		 int t=in.nextInt();
		 while(t-->0)
		 {
		      int n=in.nextInt();
		      int a[]=new int[n];
		      for(int i=0;i<n;i++)
		      {
		          a[i]=in.nextInt();
		      }
		 }    //System.out.println(water(a,n));
    }
	
	public static int water(int a[],int n)
	 {
	     int max=-1;
	     
	     int l[]=new int[n];
	     l[0]=a[0];
	     for(int i=1;i<n;i++)
	     {
	         l[i]=Math.max(l[i-1],a[i]);
	     }
	     
	     int r[]=new int[n];
	     r[n-1]=a[n-1];
	     
	     for(int i=n-2;i>=0;i--)
	     {
	         r[i]=Math.max(r[i+1],a[i]);
	     }
	     
	     for(int i=0;i<n;i++)
	     {
	         max+=a[i]-Math.min(l[i],r[i]);
	     }
	     
	     return max;
	 }
	

}
