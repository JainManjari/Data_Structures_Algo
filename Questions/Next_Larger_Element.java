package Questions;

import java.util.*;

class Pair
{
    long par;
    long ele;
    
    public Pair(){};
    
    public Pair(long par,long ele)
    {
        this.par=par;
        this.ele=ele;
    }
}


public class Next_Larger_Element {
	
	 public static void nextLargerElement(long[] arr, int n) { 
	        // Your code here
	        HashMap<Long,Integer> map=new HashMap<>();
	        long ans[]=new long[n];
	        Stack<Long> s=new Stack<>();
	        s.push(arr[0]);
	        map.put(arr[0],0);
	        
	        ArrayList<Pair> a=new ArrayList<>();
	        
	        for(int i=1;i<n;i++)
	        {
	            while(!s.isEmpty() && s.peek()<arr[i])
	            {
	                long c=s.pop();
	                Pair p=new Pair(c,arr[i]);
	                a.add(p);
	            }
	            s.push(arr[i]);
	            map.put(arr[i],i);
	        }
	        
	        while(!s.isEmpty())
	        {
	            long c=s.pop();
	            long one=Long.valueOf("-1");
	            Pair p=new Pair(c,one);
	            a.add(p);
	        }
	        
	        for(int i=0;i<a.size();i++)
	        {
	            Pair p=a.get(i);
	            int ind=map.get(p.par);
	            ans[ind]=p.ele;
	            
	        }
	        
	        for(int i=0;i<ans.length;i++)
	        {
	            System.out.print(ans[i]+" ");
	        }
	    } 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long a[]= {6, 8 ,0 ,1 ,3};
		nextLargerElement(a, a.length);

	}

}
