package QImplementation;

import LinkedList.*;

import java.util.*;
import java.util.LinkedList;

class Q
{
	private int data[];
	private int front;
	private int rear;
	private int size;
	
	public Q()
	{
		data=new int[10];
		front=-1;
		rear=-1;
		size=0;
	}
	
	public Q(int n)
	{
		data=new int[n];
		front=-1;
		rear=-1;
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
	
	public void enqueue(int ele) //throws QueueFullException
	{
		if(size==data.length)
		{
			data=doubleCapacity();
		}
		if(size==0)
		{
			front=0;
			rear=0;
		}
		else
		{
			rear=(rear+1)%data.length;
		}
		size++;
		data[rear]=ele;
	}
	
	private int[] doubleCapacity()
	{
		int temp[]=new int[data.length*2];
		int index=0;
		for(int i=front;i<data.length;i++)
		{
			temp[index++]=data[i];
		}
		for(int i=0;i<front;i++)
		{
			temp[index++]=data[i];
		}
		front=0;
		rear=data.length-1;
		return temp;
		
	}
	
	public int dequeue() throws QueueEmptyException 
	{
		if(isEmpty())
		{
			throw new QueueEmptyException();
		}
		int c=data[front];
		size--;
		if(size==0)
		{
			front=-1;
			rear=-1;
		}
		else
		{
			front=(front+1)%data.length;
		}
		return c;
	}
}

class QUsingLL<T>
{
	Node<T> head;
	Node<T> tail;
	int size;
	
	public QUsingLL()
	{
		tail=null;
		head=null;
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
	
	public void enqueue(T ele)
	{
		Node<T> newNode=new Node(ele);
		
		if(head==null)
		{
			head=newNode;
			tail=newNode;
		}
		else
		{
			tail.next=newNode;
			tail=newNode;
		}
		size++;
	}
	
	public T front() throws QueueEmptyException
	{
		if(isEmpty())
		{
			throw new QueueEmptyException();
		}
		return head.data;
	}
	
	public T dequeue() throws QueueEmptyException
	{
		if(isEmpty())
		{
			throw new QueueEmptyException();
		}
		T c=head.data;
		head=head.next;
		size--;
		return c;
	}
	
	
}
public class QImplement {
	

	public static void main(String[] args) //throws QueueFullException 
	{
		// TODO Auto-generated method stub
		
		Q q1=new Q();
		for(int i=1;i<=12;i++)
		{
			q1.enqueue(i);
		}
		
		while(q1.size()!=5)
		{
			try
			{
				System.out.print(q1.dequeue()+" ");
			}
			catch(QueueEmptyException e)
			{
				
			}
		}
		
		for(int i=11;i<=15;i++)
		{
			q1.enqueue(i);
		}
		
		System.out.println();
		
		while(!q1.isEmpty())
		{
			try
			{
				System.out.print(q1.dequeue()+" ");
			}
			catch(QueueEmptyException e)
			{
				
			}
		}
		
		System.out.println();
		
		QUsingLL<Integer> q2=new QUsingLL<>();
		
		for(int i=1;i<=12;i++)
		{
			q2.enqueue(i);
		}
		
		while(q2.size()!=5)
		{
			try
			{
				System.out.print(q2.dequeue()+" ");
			}
			catch(QueueEmptyException e)
			{
				
			}
		}
		
		for(int i=11;i<=15;i++)
		{
			q2.enqueue(i);
		}
		
		System.out.println();
		
		while(!q2.isEmpty())
		{
			try
			{
				System.out.print(q2.dequeue()+" ");
			}
			catch(QueueEmptyException e)
			{
				
			}
		}
		Queue<Integer> a=new LinkedList<Integer>();
		
	}

}
