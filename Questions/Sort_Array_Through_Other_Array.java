package Questions;

import java.util.*;

class MyArrayListComparator implements Comparator<ArrayList>
{
    public int compare(ArrayList al1, ArrayList al2)
    {
        int d1 = (int)al1.get(1) - (int)al2.get(1);
        int d2 = (int)al2.get(0) - (int)al1.get(0);
        if((int)al1.get(0) == (int)al2.get(0))
            return d1;
        else
            return d2;

    }
}  

public class Sort_Array_Through_Other_Array {

	  
      
    public static ArrayList<Integer> arrange(ArrayList<Integer> A, ArrayList<Integer> B, int n)
    {
        ArrayList<ArrayList<Integer> > people = new ArrayList<ArrayList<Integer> >(n);
        for(int i=0; i<n; i++)
        {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            people.add(temp);
        }
        
        for(int i=0; i<n; i++)
        {
            people.get(i).add(A.get(i)); 
            people.get(i).add(B.get(i)); 
        }
        
        MyArrayListComparator my=new MyArrayListComparator();
        
        Collections.sort(people, my);
            
        ArrayList<Integer> ans = new ArrayList<Integer>();
        
        for(int i =0; i<n; i++)
        	//index,ele
           ans.add(people.get(i).get(1) , people.get(i).get(0));
        
        return ans;   
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> A= new ArrayList<Integer>();
		A.add(5);A.add(3);A.add(2);A.add(6);A.add(1);A.add(4);
		int n=6;
		ArrayList<Integer> B= new ArrayList<Integer>();
		B.add(0);B.add(1);B.add(2);B.add(0);B.add(3);B.add(2);
		
		ArrayList<Integer> ans= arrange(A,B,n);
		
		for(int i=0;i<ans.size();i++)
		{
			System.out.print(ans.get(i)+" ");
		}
	
		
	}

}
