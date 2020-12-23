package Stack;
import LinkedList.*;
import java.util.*;

class Stk{
	
	private int top;
	private int data[];
	private int size;
	
	public Stk()
	{
		top=-1;
		data=new int[10];
		size=0;
	}
	
	public Stk(int n)
	{
		top=-1;
		data=new int[n];
		size=0;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	public boolean isFull()
	{
		return size==data.length;
	}
	
	public int top() throws StackEmptyException
	{
		if(isEmpty())
		{
			throw new StackEmptyException();
		}
		return data[top];
	}
	
	public void push(int ele) //throws StackFullException
	{
		if(isFull())
		{
			//throw new StackFullException();
			data=doubleCapacity();
		}
		size++;
		top++;
		data[top]=ele;
	}
	
	private int[] doubleCapacity() {
		int temp[]=new int[data.length*2];
		for(int i=0;i<data.length;i++)
		{
			temp[i]=data[i];
		}
		return temp;
		
	}

	public int pop() throws StackEmptyException
	{
		if(isEmpty())
		{
			throw new StackEmptyException();
		}
		int c=data[top];
		top--;
		size--;
		return c;
	}
	
}


class StackUsingLL<T>
{
	private Node<T> head;
	private int size;
	
	public StackUsingLL()
	{
		head=null;
		size=0;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return head==null;
	}
	
	public T top() throws StackEmptyException
	{
		if(head==null)
		{
			throw new StackEmptyException();
		}
		return head.data;
	}
	
	public void push(T ele)
	{
		Node<T> newNode=new Node(ele);
		if(head==null)
		{
			head=newNode;
		}
		else
		{
			newNode.next=head;
			head=newNode;
		}
		size++;
		
	}
	
	public T pop() throws StackEmptyException
	{
		if(head==null)
		{
			throw new StackEmptyException();
		}
		T c=head.data;
		head=head.next;
		size--;
		return c;
	}
}

public class Stack {
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Stk s1=new Stk();
        for(int i=1;i<=21;i++)
        {
        	s1.push(i);
        }
       
        while(!s1.isEmpty())
        {
        	try
        	{
        		System.out.println(s1.pop());
        	}
        	catch(StackEmptyException e){
        		
        	}
        }
        System.out.println();
        
        StackUsingLL<Integer> s2=new StackUsingLL();
        for(int i=1;i<=21;i++)
        {
        	s2.push(i);
        }
        
        while(!s2.isEmpty())
        {
        	try
        	{
        		System.out.println(s2.pop());
        	}
        	catch(StackEmptyException e){
        		
        	}
        }
        
//        Stack s=new Stack();
        
	}

}
