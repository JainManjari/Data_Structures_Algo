package Heap;

import java.util.*;


 class Triplet
 {
	 int ele;
	 int eleArrayIndex;
	 int eleListIndex;
	 int eleArraySize;
 }
 
 class Comparator1 implements Comparator<Triplet>
 {

	
	public int compare(Triplet o1, Triplet o2) {
		if(o1.ele<o2.ele)
		{
			return -1;
		}
		else if(o1.ele>o2.ele)
		{
			return 1;
		}
		return 0;
	}
	 
 }
class HeapMin
{
	private ArrayList<Integer> heap;
	//private int size;
	
	public HeapMin()
	{
		heap=new ArrayList<>();
		//size=0;
	}
	
	public boolean isEmpty()
	{
		return heap.size()==0;
	}
	
	public int size()
	{
		return heap.size();
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
		int parentI=(childI-1)/2;
		
		while(childI>0)
		{
			if(heap.get(parentI)>heap.get(childI))
			{
				int temp=heap.get(parentI);
				heap.set(parentI, heap.get(childI));
				heap.set(childI, temp);
				childI=parentI;
				parentI=(childI-1)/2;
			}
			else
			{
				return;
			}
		}
		//size++;
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
		int leftC=(2*parentI+1);
		int rightC=(2*parentI+2);
		
		while(leftC<heap.size())
		{
			if(rightC<heap.size())
			{
				if(heap.get(parentI)>heap.get(leftC) || heap.get(parentI)>heap.get(rightC))
				{
					int min=Math.min(heap.get(rightC), heap.get(leftC));
					int index=heap.indexOf(min);
					int temp=heap.get(parentI);
					heap.set(parentI, min);
					heap.set(index, temp);
				}
				else
				{
					break;
				}
			}
			else
			{
				if(heap.get(parentI)>heap.get(leftC))
				{
					int temp=heap.get(parentI);
					heap.set(parentI, heap.get(leftC));
					heap.set(leftC, temp);
				}
				else
				{
					break;
				}
			}
			parentI++;
			leftC=2*parentI+1;
			rightC=2*parentI+2;
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

class HeapMax
{
	private ArrayList<Integer> heap;
	
	public HeapMax()
	{
		heap=new ArrayList<>();
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
		int parentI=(childI-1)/2;
		
		while(childI>0)
		{
			if(heap.get(parentI)<heap.get(childI))
			{
				int temp=heap.get(parentI);
				heap.set(parentI, heap.get(childI));
				heap.set(childI, temp);
				childI=parentI;
				parentI=(childI-1)/2;
			}
			else
			{
				return;
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
		heap.set(0, heap.get(heap.size()-1));
		heap.remove(heap.size()-1);
		
		int parentI=0;
		int childL=(2*parentI+1);
		int childR=(2*parentI+2);
		
		while(childL<heap.size())
		{
			if(childR<heap.size())
			{
				if(heap.get(parentI)<heap.get(childL) || heap.get(parentI)<heap.get(childR))
				{
					int max=Math.max(heap.get(childR), heap.get(childL));
					int index=heap.indexOf(max);
					int temp=heap.get(parentI);
					heap.set(parentI, heap.get(index));
					heap.set(index, temp);
				}
				else
				{
					break;
				}
			}
			else
			{
				if(heap.get(parentI)<heap.get(childL))
				{
					int temp=heap.get(parentI);
					heap.set(parentI, heap.get(childL));
					heap.set(childL, temp);
				}
				else
				{
					break;
				}
			}
			parentI++;
			childL=(2*parentI+1);
			childR=(2*parentI+2);
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

public class HeapClass {
	
	public static void main(String args[]) throws HeapEmptyException
	{
//		ArrayList<Integer> a=new ArrayList<>();
//		for(int i=1;i<=5;i++)
//		{
//			a.add(i);
//		}
//		for(int i=0;i<a.size();i++)
//		{
//			System.out.print(a.get(i)+" ");
//		}
//		System.out.println();
//		System.out.println(a.indexOf(6));
		
//		HeapMin h=new HeapMin();
//		h.insert(10);
//		h.insert(5);
//		h.insert(15);
//		h.insert(2);
//		h.insert(4);
//		h.insert(20);
//		h.display();
//		System.out.println(h.size());
//        while(!h.isEmpty())
//        {
//        	System.out.println(h.removeMin());
//        }
//        System.out.println();
//        HeapMax h1=new HeapMax();
//		h1.insert(10);
//		h1.insert(5);
//		h1.insert(15);
//		h1.insert(2);
//		h1.insert(4);
//		h1.insert(20);
//		h1.display();
//		System.out.println(h1.size());
//		while(!h1.isEmpty())
//        {
//        	System.out.println(h1.removeMax());
//        }
//        System.out.println();
//        
//        int a[]= {6,2,1,5,19,18};
//        
//        for(int i=0;i<a.length;i++)
//        {
//        	insert(a[i],i,a);
//        }
//        
//        for(int i=0;i<a.length;i++)
//        {
//        	//System.out.print(a[i]+" ");
//        }
//        System.out.println();
//        
//        for(int i=0;i<a.length;i++)
//        {
//        	a[a.length-1-i]=removeMin(a,a.length-i);
//        }
//        
//        for(int i=0;i<a.length;i++)
//        {
//        //	System.out.print(a[i]+" ");
//        }
//        System.out.println();
//        
//        PriorityQueue<Integer> pq=new PriorityQueue<>();
//       
//        for(int i=0;i<a.length;i++)
//        {
//        	pq.add(a[i]);
//        }
//        
//        while(!pq.isEmpty())
//        {
//        	//System.out.println(pq.remove());
//        }
        

        
        Scanner s = new Scanner(System.in);
//		int k = s.nextInt();
//		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
//		while(k > 0) {
//			int n = s.nextInt();
//			ArrayList<Integer> current = new ArrayList<Integer>();
//			for(int i = 0; i < n; i++) {
//				current.add(s.nextInt());
//			}
//			input.add(current);
//			k--;
//		}
//		ArrayList<Integer> output = kSortedArrays(input);
//		for(int i : output) {
//			System.out.print(i + " ");
//		}
        
       
        
		
		/*
	
		4
		4
		5 6 10 25
		5
		1 2 4 15 28
		3
		2 3 9
		5
		7 8 12 16 29
		
		*/
        
		
		int a[]= {6, 5, 3, 2, 8, 10, 9};
		
		sortedKsort(a, 3);
		
		for(int i=0;i<a.length;i++)
		{
			System.out.print(a[i]+" ");
		}
		System.out.println();

	}
	

	private static ArrayList<Integer> kSortedArrays(ArrayList<ArrayList<Integer>> input) 
	{
		//System.out.println("start");
		ArrayList<Integer> a=new ArrayList<>();
		Comparator1 c=new Comparator1();
		PriorityQueue<Triplet> pq=new PriorityQueue<>(c);
		for(int i=0;i<input.size();i++)
		{
			ArrayList<Integer> b=input.get(i);
			Triplet t=new Triplet();
			t.ele=b.get(0);
			t.eleArrayIndex=0;
			t.eleArraySize=b.size();
			t.eleListIndex=i;
			pq.add(t);
		}
		while(!pq.isEmpty())
		{
			Triplet t=pq.remove();
			a.add(t.ele);
			t.eleArrayIndex+=1;
			if(t.eleArrayIndex<t.eleArraySize)
			{
				
				ArrayList<Integer> b=input.get(t.eleListIndex);
				t.ele=b.get(t.eleArrayIndex);
				//System.out.println(t.eleListIndex+" "+t.eleArrayIndex+" "+t.eleArraySize+" "+t.ele);
				pq.add(t);
			}
				
		}
		return a;
	}


	public static void sortedKsort(int a[],int k)
	{
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		
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
	
	public static int removeMin(int a[],int length)
	{
		int ele=a[0];
		a[0]=a[length-1];
		//a[length-1]=ele;
		int newLength=length-1;
		int pI=0;
		//int index=pI;
		int cLI=2*pI+1;
		int cRI=2*pI+2;
		
		while(cLI<newLength)
		{
			int index=pI;
			if(a[index]>a[cLI])
			{
				index=cLI;
			}
			if(cRI<newLength && a[cRI]<a[index])
			{
				index=cRI;
			}
			if(index==pI)
			{
				break;
			}
			int temp=a[index];
			a[index]=a[pI];
			a[pI]=temp;
			pI++;
			cLI=2*pI+1;
			cRI=2*pI+2;
			//index=pI;
		}
		return ele;
	}
	public static void insert(int ele,int child,int a[])
	{
		a[child]=ele;
		int p=(child-1)/2;
		
		while(child>0)
		{
			if(a[p]>a[child])
			{
				int temp=a[p];
				a[p]=a[child];
				a[child]=temp;
				child=p;
				p=(child-1)/2;
			}
			else
			{
				break;
			}
		}
		
	}

}
