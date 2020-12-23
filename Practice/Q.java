package Practice;
import LinkedList.*;

import QImplementation.QueueEmptyException;
import QImplementation.QueueFullException;

class Q1
{
	private int front;
	private int rear;
	private int size;
	private int data[];
	
	public Q1()
	{
		this.front=-1;
		this.rear=-1;
		this.size=0;
		this.data=new int[10];
	}
	
	public Q1(int n)
	{
		this.front=-1;
		this.rear=-1;
		this.size=0;
		this.data=new int[n];
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	public int size()
	{
		return size;
	}
	
	public boolean isFull()
	{
		return data.length==size;
	}
	
	public void enqueue(int n) //throws QueueFullException
	{
		if(isFull())
		{
			doubleCapacity();
			//throw new QueueFullException();
		}
		size++;
		if(front==-1)
		{
			front=0;
			rear=0;
		}
		else
		{
			rear=(rear+1)%data.length;
		}
		data[rear]=n;
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
	
	public void doubleCapacity()
	{
		int temp[]=new int[data.length*2];
		int k=0;
		for(int i=front;i<=rear;i++)
		{
			temp[k++]=data[i];
		}
		for(int i=0;i<front;i++)
		{
			temp[k++]=data[i];
		}
		front=0;
		rear=data.length-1;
		data=temp;
	}
}

class QLL<T>
{
	Node<T> head;
	Node<T> tail;
	int size;
	
	public QLL()
	{
		this.head=null;
		this.tail=null;
		this.size=0;
	}
	
	public boolean isEmpty()
	{
		return size==0;
	}
	
	public int size()
	{
		return size;
	}
	
	public T top() throws QueueEmptyException
	{
		if(isEmpty())
		{
			throw new QueueEmptyException();
		}
		return head.data;
	}
	
	public void enqueue(T data)
	{
		Node<T> newnode= new Node(data);
		if(head==null)
		{
			head=newnode;
			tail=newnode;
		}
		tail.next=newnode;
		tail=newnode;
		size++;
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


public class Q {
	
	public static void main(String args[]) throws QueueEmptyException
	{
		Q1 q=new Q1();
		for(int i=0;i<14;i++)
		{
			
				q.enqueue(i);
			
		}
		while(!q.isEmpty())
		{
			System.out.print(q.dequeue()+" ");
		}
	}

}
