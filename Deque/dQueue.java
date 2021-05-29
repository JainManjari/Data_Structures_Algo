package Deque;

public class dQueue {
	
	int front;
	int rear;
	int size;
	int a[];
	
	public dQueue()
	{
		a=new int[5];
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
	
	public int getFront()
	{
		if(isEmpty())
		{
			return -1;
		}
		return a[front];
	}
	
	public int getRear()
	{
		if(isEmpty())
		{
			return -1;
		}
		return a[rear];
	}
	
	public void insertFront(int ele)
	{
		if(front==-1)
		{
			front=0;
			rear=0;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
