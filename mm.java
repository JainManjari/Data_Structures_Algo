import java.util.*;

class Pair implements Comparable<Pair>
{
	int first;
	int second;
	
	public int compareTo(Pair i)
	{
		return this.first-i.first;
	}
}

public class mm {
	
	public static void main(String args[])
	{
		Scanner in=new Scanner(System.in);
		int ans=0;
		int a[]= {4, 3, 2, 1};
		Pair vector[]=new Pair[a.length];
		for(int i=0;i<a.length;i++)
		{
			vector[i]=new Pair();
			vector[i].first=a[i];
			vector[i].second=i;
		}
		Arrays.sort(vector);
		for(int i=0;i<a.length;i++)
		{
			if(i==vector[i].second)
			{
				continue;
			}
			//System.out.println(vector[i].first+" "+vector[i].second+" "+vector[vector[i].second].first+" "+vector[vector[i].second].second);
			int temp=vector[i].first;
			vector[i].first=vector[vector[i].second].first;
			vector[vector[i].second].first=temp;
			
			int temp1=vector[i].second;
			vector[i].second=vector[vector[i].second].second;
			vector[vector[i].second].second=temp1;
			
			//System.out.println(vector[i].first+" "+vector[i].second);
			
			ans++;
		}
		//System.out.print(ans);
		
	}

}
