package StackQuestions;
import java.util.*;

public class minStack {

	Stack<Integer> s;
	int min;
	
	public minStack()
	{
		s=new Stack<Integer>();
		min=-1;
	}
	
	public void push(int ele)
	{
		if(s.isEmpty())
		{
			s.push(ele);
			min=ele;
		}
		else
		{
			if(ele<=min)
			{
				s.push(2*ele-min);
				min=ele;
			}
			else
			{
				s.push(ele);
			}
		}
	}
	
	public int getMin()
	{
		if(s.isEmpty())
		{
			return -100;
		}
		return min;
	}
	
	public int peek()
	{
		if(s.isEmpty())
		{
			return -100;
		}
		int t=s.peek();
		return (t<=min)? min:t;
	}
	
	public int pop()
	{
		if(s.isEmpty())
		{
			return -100;
		}
		int t=s.pop();
		if(t<=min)
		{
			int res=min;
			min=2*min-t;
			return res;
		}
		return t;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minStack min=new minStack();
		
		min.push(10);
		System.out.println("min working "+min.peek()+" "+min.getMin());
		min.push(5);
		System.out.println("min working "+min.peek()+" "+min.getMin());
		min.push(20);
		System.out.println("min working "+min.peek()+" "+min.getMin());
		min.push(2);
		min.push(6);
		min.push(4);
		
		int c=min.pop();
		System.out.println("min working "+min.peek()+" "+min.getMin()+" "+c);
		c=min.pop();
		System.out.println("min working "+min.peek()+" "+min.getMin()+" "+c);
	}

}
