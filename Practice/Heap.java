package Practice;
import java.util.*;
import java.util.LinkedList;


class HPMax
{
	ArrayList<Integer> heap;
	
	public HPMax()
	{
		heap=new ArrayList<Integer>();
	}
	
	public int size()
	{
		return heap.size();
	}
	
	public boolean isEmpty()
	{
		return heap.size()==0;
	}
	
	public int getMax() throws HeapEmptyException
	{
		if(isEmpty())
		{
			throw new HeapEmptyException();
		}
		
		return heap.get(0);
	}
	
	public void insert(int ele)
	{
		heap.add(ele);
		
		int childI=heap.size()-1;
		
		while(childI!=0)
		{
			int parentI=(childI-1)/2;
			
			if(heap.get(childI)>heap.get(parentI))
			{
				int temp=heap.get(childI);
				heap.set(childI, heap.get(parentI));
				heap.set(parentI, temp);
				childI=parentI;
			}
			else 
			{
				break;
			}
		}
	}
	
	public int removeMax() throws HeapEmptyException
	{
		if(isEmpty())
		{
			throw new HeapEmptyException();
		}
		
		int c=heap.get(0);
		
		heap.set(0,heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int parentI=0;
		int leftI=2*parentI+1;
		int rightI=2*parentI+2;
		
		while(leftI<heap.size())
		{
			int maxI=parentI;
			
			if(heap.get(leftI)>heap.get(maxI))
			{
				maxI=leftI;
			}
			
			if(rightI<heap.size() && heap.get(rightI)>heap.get(maxI))
			{
				maxI=rightI;
			}
			
			if(maxI!=parentI)
			{
				int temp=heap.get(maxI);
				heap.set(maxI, heap.get(parentI));
				heap.set(parentI, temp);
				parentI++;
				leftI=2*parentI+1;
				rightI=2*parentI+2;
			}
			else
			{
				break;
			}
		}
		
		return c;
	}
}

class HP
{
	ArrayList<Integer> heap;
	
	public HP()
	{
		heap=new ArrayList<Integer>();
	}
	
	public int size()
	{
		return heap.size();
	}
	
	public boolean isEmpty()
	{
		return heap.size()==0;
	}
	
	public int getMin() throws HeapEmptyException
	{
		if(isEmpty())
		{
			throw new HeapEmptyException();
		}
		
		return heap.get(0);
	}
	public void insert(int ele)
	{
		heap.add(ele);
		int childI=heap.size()-1;
//		System.out.println("childI "+childI);
		while(childI!=0)
		{
			int parentI=(childI-1)/2;
			//System.out.println("inside "+childI+" "+parentI);
			if(heap.get(childI)<heap.get(parentI))
			{
				int temp=heap.get(childI);
				heap.set(childI, heap.get(parentI));
				heap.set(parentI,temp);
			}
			childI=parentI;
		}
	}
	
	public int removeMin() throws HeapEmptyException
	{
		if(isEmpty())
		{
			throw new HeapEmptyException();
		}
		
		int c=heap.get(0);
		
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int parentI=0;
		int leftI=2*parentI+1;
		int rightI=2*parentI+2;
		
		while(leftI<heap.size())
		{
			int minI=parentI;
			
			if(heap.get(minI)>heap.get(leftI))
			{
				minI=leftI;
			}
			
			
			if(rightI<heap.size() && heap.get(minI)>heap.get(rightI))
			{
				minI=rightI;
			}
			
			if(minI!=parentI)
			{
				int temp=heap.get(minI);
				
				
				
				heap.set(minI, heap.get(parentI));
				heap.set(parentI, temp);
				parentI++;
				leftI=2*parentI+1;
				rightI=2*parentI+2;
			}
			else
			{
				break;
			}
			
		}
		
		return c;
	}
	
	public void display()
	{
		for(int i=0;i<heap.size();i++)
		{
			System.out.print(heap.get(i)+" ");
		}
		System.out.println();
	}
}

class Max implements Comparator<Integer>
{
	public int compare(Integer o1,Integer o2)
	{
		if(o2>o1)
		{
			return 1;
		}
		if(o2<o1)
		{
			return -1;
		}
		return 0;
	}

	
}

public class Heap {
	

	
	public static void sortKSort(int a[],int k)
	{
		PriorityQueue<Integer> pq=new PriorityQueue();
		
		for(int i=0;i<k+1;i++)
		{
			pq.add(a[i]);
		}
		
		int index=0;
		
		for(int i=k+1;i<a.length;i++)
		{
			a[index++]=pq.remove();
			pq.add(a[i]);
		}
		
		while(!pq.isEmpty())
		{
			a[index++]=pq.remove();
		}
	}
	public static void main(String[] args) throws HeapEmptyException {
		// TODO Auto-generated method stub
		
		PriorityQueue<Integer> minq=new PriorityQueue();
		PriorityQueue<Integer> maxq=new PriorityQueue<Integer>(Collections.reverseOrder());
		Max max=new Max();
		PriorityQueue<Integer> maxq2=new PriorityQueue<Integer>(max);
		
		
		
		
		/*
		 * 
		 * Sort a nearly sorted (or K sorted) array
			
			Given an array of n elements, where each element is at 
			most k away from its target position, devise an algorithm 
			that sorts in O(n log k) time. 
			.
			
			Examples:
			
			Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
			            k = 3 
			Output : arr[] = {2, 3, 5, 6, 8, 9, 10}
			
			Input : arr[] = {10, 9, 8, 7, 4, 70, 60, 50}
			         k = 4
			Output : arr[] = {4, 7, 8, 9, 10, 50, 60, 70}

		 */
		
		int arr[] = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
		sortKSort(arr, k);
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print(arr[i]+" ");
		}
		
		
		
		
		
		
		
		
		
		
		
		
//		int a[]= {5,10,15,2,4,20};
//		
//		HP h=new HP();
//		
//		for(int i=0;i<a.length;i++)
//		{
//			h.insert(a[i]);
//		}
//		
//		h.display();
//		
////		System.out.println(h.removeMin());
////		
////		h.display();
////		
////		System.out.println(h.removeMin());
////		
////		h.display();
////		
////		
////		System.out.println(h.removeMin());
////		
////		h.display();
////		
////		
////		System.out.println(h.removeMin());
////		
////		h.display();
//		
//		while(!h.isEmpty())
//		{
//			System.out.println(h.removeMin());
//		}
//		
//		System.out.println();

	}

}
