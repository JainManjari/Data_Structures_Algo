package Heap;

import java.util.*;

class MaxComparator implements Comparator<Integer>
{

	@Override
	public int compare(Integer o1, Integer o2) {
		// TODO Auto-generated method stub
		if(o1<o2)
		{
			return 1;
		}
		if(o1>o2)
		{
			return -1;
		}
		return 0;
	}
	
}

public class runningMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[]= {5,15,10,20,3};
		MaxComparator maxi=new MaxComparator();
		PriorityQueue<Integer> min=new PriorityQueue<Integer>();
		PriorityQueue<Integer> max=new PriorityQueue<Integer>(new MaxComparator());
		double median=0;
		for(int i=0;i<a.length;i++)
		{
			if(min.size()==max.size())
			{
				if(a[i]<median)
				{
					max.add(a[i]);
					median=(double)max.peek();
				}
				else
				{
					min.add(a[i]);
					median=(double)min.peek();
				}
			}
			else if(max.size()>min.size())
			{
				if(a[i]<median)
				{
					min.add(max.remove());
					max.add(a[i]);
				}
				else
				{
					min.add(a[i]);
				}
				median=(double)(1.0*(min.peek()+max.peek())/2);
			}
			else
			{
				if(a[i]>=median)
				{
					max.add(min.remove());
					min.add(a[i]);
				}
				else
				{
					max.add(a[i]);
				}
				median=(double)(1.0*(min.peek()+max.peek())/2);
			}
			System.out.println(median);
		}

	}

}
