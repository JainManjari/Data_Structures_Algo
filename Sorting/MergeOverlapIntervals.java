package Sorting;
import java.util.*;

class Point implements Comparable<Point>
{
	int x;
	int y;
	
	public int compareTo(Point p)
	{
		return this.x-p.x;
	}
}

public class MergeOverlapIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 *  5
			6 10
			4 5
			7 9
			2 4
			1 3
		 */
		
		Scanner in=new Scanner(System.in);
		int n=in.nextInt();
		
		Point p[]=new Point[n];
		
		for(int i=0;i<n;i++)
		{
			p[i]=new Point();
			p[i].x=in.nextInt();
			p[i].y=in.nextInt();
		}
		
		Arrays.sort(p);
		
		for(int i=0;i<n;i++)
		{
			System.out.println(p[i].x+" "+p[i].y);
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		merge(p);
		
		

	}
	
	public static void merge(Point p[])
	{
		int res=0;
		
		for(int i=1;i<p.length;i++)
		{
			if(p[res].y>=p[i].x)
			{
				p[res].x=Math.min(p[res].x, p[i].x);
				p[res].y=Math.max(p[res].y, p[i].y);
			}
			else
			{
				res++;
				p[res]=p[i];
			}
		}
		

		for(int i=0;i<=res;i++)
		{
			System.out.println(p[i].x+" "+p[i].y);
		}
	}

}
