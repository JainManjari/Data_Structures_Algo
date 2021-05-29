package StackQuestions;
import java.util.*;

public class largestHistogram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a[]= {6,2,5,4,1,5,6};
		int n=a.length;
		
		System.out.println(largestHist(a, n));

	}
	
	public static int largestHist(int a[],int n)
	{
		Stack<Integer> s=new Stack<Integer>();
		int res=0;
		
		for(int i=0;i<n;i++)
		{
			while(!s.isEmpty() && a[s.peek()]>=a[i])
			{
				int t=s.pop();
				int curr=a[t]*(s.isEmpty() ? i : i-s.peek()-1);
				res=Math.max(res, curr);
			}
			s.push(i);
		}
		
		while(!s.isEmpty())
		{
			int t=s.pop();
			int curr=a[t]*(s.isEmpty()?n:n-s.peek()-1);
			res=Math.max(res, curr);
		}
		
		return res;
	}

}
