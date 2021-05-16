package Questions;
import java.util.*;

public class Kadane {

	public static int maxsum(int arr[],int n)
	{
		int maxsum=arr[0];
		int sum=0;
		
		for(int i=0;i<n;i++)
		{
			sum+=arr[i];
			if(sum>maxsum)
			{
				maxsum=sum;
			}
			if(sum<0)
			{
				sum=0;
			}
		}
		
		return maxsum;
	}
	
	
	public static int maxprod(int arr[],int n)
	{
		int max_so_far=0;
		int max_pos=1;
		int max_neg=1;
		int flag=0;
		
		for(int i=0;i<arr.length;i++)
		{
			if(arr[i]>0)
			{
				max_pos=max_pos*arr[i];
				max_neg=Math.min(1, max_pos);
				flag=1;
			}
			else if(arr[i]<0)
			{
				int t=max_pos;
				max_pos=Math.max(max_neg*arr[i], 1);
				max_neg=t*arr[i];
			}
			else
			{
				max_pos=1;
				max_neg=1;
			}
			if(max_pos>max_so_far)
			{
				max_so_far=max_pos;
			}
		}
		if(flag==0 && max_so_far==0)
		{
			return 0;
		}
		return max_so_far;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
