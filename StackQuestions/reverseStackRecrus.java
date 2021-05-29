package StackQuestions;
import java.util.*;

public class reverseStackRecrus {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stack<Integer> s=new Stack<Integer>();
		s.push(10);s.push(12);s.push(13);s.push(14);s.push(15);
		
		while(!s.isEmpty())
		{
			System.out.print(s.pop()+" ");
		}
		System.out.println();
		s.push(10);s.push(12);s.push(13);s.push(14);s.push(15);
		
		reverseStack(s);
		
		while(!s.isEmpty())
		{
			System.out.print(s.pop()+" ");
		}
	}
	
	public static void reverseStack(Stack<Integer> s)
	{
		if(s.size()>0)
		{
			int x=s.pop();
			reverseStack(s);
			insertAtBottom(s,x);
		}
	}

	public static void insertAtBottom(Stack<Integer> s,int ele) {
		if(s.isEmpty())
		{
			s.push(ele);
			return;
		}
		
		int a=s.pop();
		insertAtBottom(s, ele);
		s.push(a);
	}

}
