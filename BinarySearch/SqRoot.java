package BinarySearch;
import java.util.*;

public class SqRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int n=21;
		
		System.out.println(sqRoot(n));

	}
	
	
	public static int sqRoot(int n)
	{
		int num=1;
		
		int start=1;
		int last=n;
		
		while(start<=last)
		{
			int mid=(start+last)/2;
			
			//System.out.println("func "+start+" "+" "+last+" "+mid);
			
			if(mid*mid==n)
			{
				num=mid;
				break;
			}
			if(mid*mid<n)
			{
				start=mid+1;
				num=mid;
			}
			else
			{
				last=mid-1;
			}
		}
		
		
		return num;
	}

}
