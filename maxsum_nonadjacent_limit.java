import java.util.*;

public class maxsum_nonadjacent_limit {

	public static void main (String args[])
	{
		Scanner in=new Scanner(System.in);
		int limit=in.nextInt();
		int n=in.nextInt();
		int a[]=new int[n];
		for(int i=0;i<n;i++)
		{
			a[i]=in.nextInt();
		}
		
		System.out.println(sum(a,n,limit));
		
	}
	
	public static int sum(int a[],int n,int limit)
	{
		int incl=a[0];
		int ecl=0;
		int enew;
		int max=-1;
		
		for(int i=1;i<n;i++)
		{
			enew=Math.max(incl, ecl);
			incl=ecl+a[i];
			if(incl<=limit)
			{
				if(max<incl)
				{
					max=incl;
				}
			}
			
			ecl=enew;
			if(ecl<=limit)
			{
				if(max<ecl)
				{
					max=ecl;
				}
			}
		}
		return max;
	}
}
