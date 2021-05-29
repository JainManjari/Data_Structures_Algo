package Practice;
import java.util.*;

class QueueEmptyException extends Exception
{
	
}

public class QClass {
	
	int data[];
	int rear;
	int front;
	int size;
	
	public QClass()
	{
		data=new int[5];
		rear=-1;
		front=-1;
		size=0;
	}
	
	public QClass(int n)
	{
		this.data=new int[n];
		rear=-1;
		front=-1;
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
	
	public int peek() throws QueueEmptyException
	{
		if(isEmpty())
		{
			throw new QueueEmptyException();
		}
		
		return data[front];
	}
	
	public void enqueue(int n)
	{
		if(size==data.length)
		{
			doubleCapacity();
		}
		if(rear==-1)
		{
			front=0;
		}
		rear=(rear+1)%data.length;
		data[rear]=n;
		size++;
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
		
		for(int i=front;i<data.length;i++)
		{
			temp[k++]=data[i];
		}
		
		for(int i=0;i<front;i++)
		{
			temp[k++]=data[i];
		}
		
		front=0;
		rear=data.length-1;
		size=data.length;
		
		data=temp;
	}

	public static void main(String[] args) throws QueueEmptyException {
		// TODO Auto-generated method stub
		QClass q=new QClass();
		
		for(int i=0;i<5;i++)
		{
			q.enqueue(i);
		}
		
		for(int i=0;i<2;i++)
		{
			q.dequeue();
		}
		
		for(int i=0;i<10;i++)
		{
			q.enqueue(i+10);
		}
		
		while(!q.isEmpty())
		{
			System.out.println("pop "+q.dequeue());
		}

	}

}
