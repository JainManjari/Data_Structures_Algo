package Questions;

import java.util.*;

public class Sort_Array_Based_on_Other_Array {
	
	 public static void print(int a1[],int a2[],int n1,int n2)
	    {
	        TreeMap<Integer,Integer> map=new TreeMap<>();
	        
	        for(int i=0;i<n1;i++)
	        {
	            if(!map.containsKey(a1[i]))
	            {
	                map.put(a1[i],1);
	            }
	            else
	            {
	                map.put(a1[i],map.get(a1[i])+1);
	            }
	        }
	        
	        System.out.println();
	        for(int i=0;i<n2;i++)
	        {
	            if(map.containsKey(a2[i]) && map.get(a2[i])>0)
	            {
	                for(int j=0;j<map.get(a2[i]);j++)
	                {
	                    System.out.print(a2[i]+" ");
	                }
	                map.put(a2[i],0);
	            }
	            if(!map.containsKey(a2[i]))
	            {
	                System.out.print(a2[i]+" ");
	            }
	        }
	        
	        
	        for(Integer key:map.keySet())
	        {
	        	if(map.get(key)>0)
	        	{
	        		 System.out.print(key+" ");
	        	}
	           
	        }
	        
	    }
	     
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		/*
		 *  2
			11 4
			2 1 2 5 7 1 9 3 6 8 8
			2 1 8 3
			8 4
			2 6 7 5 2 6 8 4 
			2 6 4 5
		 */
		 int t=in.nextInt();
		 while(t-->0)
		 {
		      int n1=in.nextInt();
		      int n2=in.nextInt();
		      int a1[]=new int[n1];
		      for(int i=0;i<n1;i++)
		      {
		          a1[i]=in.nextInt();
		      }
		      int a2[]=new int[n2];
		      for(int i=0;i<n2;i++)
		      {
		          a2[i]=in.nextInt();
		      }
		      print(a1,a2,n1,n2);
		 }  
	}

}
