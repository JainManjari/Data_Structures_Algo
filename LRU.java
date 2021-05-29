import java.util.*;

public class LRU {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> ll=new LinkedList<Integer>();
		int seq[]= {10,20,10,30,40,50,30,40,60,30};
		
		for(int i=0;i<seq.length;i++)
		{
			if(ll.size()<4)
			{
				if(ll.contains(seq[i]))
				{
					ll.removeFirstOccurrence(seq[i]);
				}
				ll.addFirst(seq[i]);
			}
			else
			{
				if(ll.contains(seq[i]))
				{
					ll.removeFirstOccurrence(seq[i]);
				}
				else
				{
				    ll.remove(ll.size()-1);
				}
				ll.addFirst(seq[i]);
			} 
			System.out.println("list "+seq[i]+" "+ll);
		}
	}

}
