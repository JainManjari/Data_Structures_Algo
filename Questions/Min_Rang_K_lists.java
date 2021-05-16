package Questions;

import java.util.*;


class infor
{
	int listNo;
	int listIndex;
	int listElement;
	int listSize;
	
}

class minC implements Comparator<infor>
{
	public int compare(infor c1,infor c2)
	{
		if(c1.listElement>c2.listElement)
		{
			return 1;
		}
		if(c1.listElement<c2.listElement)
		{
			return -1;
		}
		return 0;
	}
}


class maxC implements Comparator<infor>
{
	public int compare(infor c1,infor c2)
	{
		if(c1.listElement>c2.listElement)
		{
			return -1;
		}
		if(c1.listElement<c2.listElement)
		{
			return 1;
		}
		return 0;
	}
}
public class Min_Rang_K_lists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 *  3
			5
			4 7 9 12 15
			5
			0 8 10 14 20
			5
			6 12 16 30 50
		 */
		Scanner in=new Scanner(System.in);
		int k=in.nextInt();
		
		ArrayList<ArrayList<Integer>> inp=new ArrayList();
		
		for(int i=0;i<k;i++)
		{
			int n=in.nextInt();
			ArrayList<Integer> a=new ArrayList<Integer>();
			for(int j=0;j<n;j++)
			{
				a.add(in.nextInt());
			}
			inp.add(a);
		}
		

		
		ArrayList<Integer> range=findRange(inp, k);
		
		System.out.print(range.get(0)+" "+range.get(1));

	}
	
	public static ArrayList<Integer> findRange(ArrayList<ArrayList<Integer>> a,int k)
	{
		//System.out.println("func call");
		ArrayList<Integer> range=new ArrayList<>();
		
		int startele=-1;
		int lastele=-1;
		int ran=Integer.MAX_VALUE;
		
		
		PriorityQueue<infor> min=new PriorityQueue(new minC());
		PriorityQueue<infor> max=new PriorityQueue(new maxC());
		
		for(int i=0;i<a.size();i++)
		{
			ArrayList<Integer> b=a.get(i);
			infor i1=new infor();
			i1.listElement=b.get(0);
			i1.listIndex=0;
			i1.listNo=i;
			i1.listSize=b.size();
			min.add(i1);
			max.add(i1);
		}
		
		
		
		while(min.peek().listIndex<min.peek().listSize)
		{
			    //System.out.println("size "+min.peek().listIndex+" "+min.peek().listSize);
				int minEle=min.peek().listElement;
				int maxEle=max.peek().listElement;
				
				int ran1=maxEle-minEle;
				
				if(ran>ran1)
				{
					ran=ran1;
					startele=minEle;
					lastele=maxEle;
				}
				
				int listNo=min.peek().listNo;
				int listIndex=min.peek().listIndex+1;

//				
//				System.out.println("List No: "+listNo);
//				
//				System.out.println("new index "+listIndex+" "+min.peek().listSize);
				
				if(listIndex==min.peek().listSize)
				{
					break;
				}
				
				max.remove(min.peek());
				min.remove();
				
				infor i1=new infor();
				i1.listElement=a.get(listNo).get(listIndex);
				i1.listIndex=listIndex;
				i1.listNo=listNo;
				i1.listSize=a.get(listNo).size();
				
			    min.add(i1);
			    max.add(i1);
				
			
		}
		
		range.add(startele);
		range.add(lastele);
		return range;
	}

}













