package Stack;
import LinkedList.*;
import java.util.Stack;

class St
{
	private int data[];
	private int top;
	private int size;
	
	public St()
	{
		this.data=new int[10];
		this.top=-1;
		this.size=0;
	}
	
	public St(int n)
	{
		this.data=new int[n];
		this.top=-1;
		this.size=0;
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
			doubleCapacity();
		}
		top++;
		size++;
		data[top]=ele;
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
	
	public void doubleCapacity()
	{
		int temp[]=new int[data.length*2];
		for(int i=0;i<data.length;i++)
		{
			temp[i]=data[i];
		}
		data=temp;
	}
}


class StLL<T>
{
	private Node<T> head;
	private int size;
	
	public StLL()
	{
		this.head=null;
		this.size=0;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	public T top() throws StackEmptyException
	{
		if(isEmpty())
		{
			throw new StackEmptyException();
		}
		return head.data;
	}
	
	public void push(T n)
	{
		Node<T> newnode=new Node<>(n);
		if(head==null)
		{
			head=newnode;
		}
		else {
			newnode.next=head;
			head=newnode;
		}
		size++;
	}
	
	public T pop() throws StackEmptyException
	{
		if(isEmpty())
		{
			throw new StackEmptyException();
		}
		size--;
		T c=head.data;
		head=head.next;
		return c;
	}
}

public class Stack_Practice {
	
	public static void main(String args[]) throws StackEmptyException
	{
//		St s=new St();
//		for(int i=1;i<18;i++)
//		{
//			
//			s.push(i);
//		}
//		
//		while(!s.isEmpty())
//		{
//			System.out.print(s.pop()+" ");
//		}
//		
		StLL<Integer> s1=new StLL<Integer>();
		for(int i=1;i<18;i++)
		{
			
			s1.push(i);
		}
		
		while(!s1.isEmpty())
		{
			System.out.print(s1.pop()+" ");
		}

		
		Stack<Character> s2=new Stack();
		System.out.println(s2.peek());
		
	}

}
