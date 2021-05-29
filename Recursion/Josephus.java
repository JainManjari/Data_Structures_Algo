package Recursion;
import java.util.*;

public class Josephus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=7;
		int k=3;
		
		System.out.println(Jose(n, k));

	}
	
	public static int Jose(int n,int k)
	{
//		ArrayList<Integer> a=new ArrayList();
//		for(int i=0;i<n;i++)
//		{
//			a.add(i);
//		}
//		
//		int index=0;
//		while(a.size()!=1)
//		{ 
//			int c=(k-1+index)%a.size();
//			index=a.get(c)+1;
//			int remove=a.remove(c);
//			System.out.println("func "+c+" item rem "+remove+" size "+a.size());
//		}
//		
//		return a.get(0);
		if(n==1)
		{
			return 0;
		}
		return (Jose(n-1, k)+k)%n;
	}

}
